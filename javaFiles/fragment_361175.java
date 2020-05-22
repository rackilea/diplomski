for(i=0;i<numOfPartitions;i++)
{
JavaPairReceiverInputDStream<String, byte[]> messages =
KafkaUtils.createStream(...);
JavaPairDStream<String, byte[]> filteredMessages =
filterValidMessages(messages);

JavaDStream<String> useCase1 = calculateUseCase1(filteredMessages);
JavaDStream<String> useCase2 = calculateUseCase2(filteredMessages);
JavaDStream<String> useCase3 = calculateUseCase3(filteredMessages);
JavaDStream<String> useCase4 = calculateUseCase4(filteredMessages);
}