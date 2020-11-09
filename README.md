# AzureEventHubProducer

This project provides a way to sends messages to Azure Event-Hub by terminal console.


## Requirements

* Java 8 or latest
* Maven
* Azure Subscription
* Azure Event Hub

## Getting start

You need to compile the project in order to get jar file. To get this, you should execute following command:
```
mvn clean package
```
The jar files will generate into target folder.

Now you can execute the sender program executing following command:
```
java -jar target/azure-eventhub-producer.jar --connection-string="$CONNECTION_STRING" --event-hub-name=$TOPIC
```

## How to use

The producer component connect with Azure Event Hub established and you can send message from terminal.
To exit from prompt you should write "exit()"
