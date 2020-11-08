package org.jmb.azureeventhubproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AzureEventhubProducerApplication

    fun main(args: Array<String>) {
        runApplication<AzureEventhubProducerApplication>(*args)
    }
