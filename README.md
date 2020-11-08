# AzureEventHubProducer

This project provides a way to sends messages to Azure Event-Hub by terminal console.


## Requirements

* Java 8 or latest
* Maven
* Azure Subscription
* Azure Event Hub

## How to use 

You need to compile the project in order to get jar file. To get this, you should execute following command:
```
mvn clean package
```
The jar files will generate into target folder.

Now you can execute the sender program executing following command:
```
java -jar target/azure-eventhub-producer-0.0.1-SNAPSHOT.jar --connection-string="$CONNECTION_STRING" --event-hub-name=$TOPIC
```
