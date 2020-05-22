@FunctionName("blob")
public String functionHandler(
            @QueueTrigger(name = "myQueueItem", queueName = "walkthrough", connection = "AzureWebJobsStorage") String queue,
            @BlobOutput(name = "blob", connection = "AzureWebJobsStorage" , path = "samples-java/2.txt") OutputBinding<String> blob) {

        blob.setValue(queue);
        return queue;
}