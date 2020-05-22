@FunctionName("consumeNodeInfo")
fun consumeNodeInfoFromQueue(@QueueTrigger(queueName = "nodeinfos", connection = "AzureWebJobsStorage", name = "nodeinfos", dataType = "binary") addedNodeInfo: ByteArray,
                             @TableOutput(name = "networkmap", tableName = "networkmap", connection = "AzureWebJobsStorage", partitionKey = "nodeInfos") table: OutputBinding<SignedNodeInfoRow>) {
    val nodeInfo = addedNodeInfo.deserialize<SignedNodeInfo>()
    table.value = SignedNodeInfoRow(nodeInfo.raw.hash.toString(), addedNodeInfo.toBase58())
}

data class SignedNodeInfoRow(val RowKey: String, val arrayAsBase58String: String)