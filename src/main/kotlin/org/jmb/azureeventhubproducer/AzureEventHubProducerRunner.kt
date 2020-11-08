package org.jmb.azureeventhubproducer

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class AzureEventHubProducerRunner() : ApplicationRunner {

    private fun isExitMessage(message: String) = "exit()" == message

    override fun run(arguments: ApplicationArguments) {

        val connectionString: String? = arguments.getOptionValues("connection-string")?.firstOrNull()
        val eventHubName: String? = arguments.getOptionValues("event-hub-name")?.firstOrNull()

        val producer = AzureEventHubProducerSender(connectionString, eventHubName)

        var message: String
        println("Enter the event message or write exit() to finish")
        do {
            print(">")
            message = readLine()!!
            if (!isExitMessage(message)) producer.send(message) else producer.close()
        } while (!isExitMessage(message))
    }
}
