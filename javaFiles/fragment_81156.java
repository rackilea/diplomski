{
  "scriptFile" : "..\\fabrikam-functions-1.0-SNAPSHOT.jar",
  "entryPoint" : "com.fabrikam.functions.Function.functionHandler",
  "bindings" : [ {
    "type" : "queueTrigger",
    "name" : "myQueueItem",
    "direction" : "in",
    "connection" : "AzureWebJobsStorage",
    "queueName" : "walkthrough"
  }, {
    "type" : "blob",
    "name" : "blob",
    "direction" : "out",
    "connection" : "AzureWebJobsStorage",
    "path" : "samples-java/2.txt"
  } ],
  "disabled" : false
}