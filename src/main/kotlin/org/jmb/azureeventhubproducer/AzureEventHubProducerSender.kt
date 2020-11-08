package org.jmb.azureeventhubproducer

import com.azure.messaging.eventhubs.EventData
import com.azure.messaging.eventhubs.EventDataBatch
import com.azure.messaging.eventhubs.EventHubClientBuilder
import com.azure.messaging.eventhubs.EventHubProducerClient
import org.springframework.util.StringUtils.isEmpty

class AzureEventHubProducerSender(connectionString: String?, eventHubName: String?) {

    private val producer: EventHubProducerClient

    init {
        require(!(isEmpty(connectionString) || isEmpty(eventHubName))) {
            "Connection-string and event-hub-name parameters must be defined"
        }

        producer = EventHubClientBuilder()
                .connectionString(connectionString, eventHubName)
                .buildProducerClient()
    }

    fun send(message: String) = createBatch(message).let { producer.send(it) }
    fun close() = producer.close()

    private fun createBatch(message: String): EventDataBatch {
        val batch = producer.createBatch()
        batch.tryAdd(EventData(message))
        return batch
    }
}
