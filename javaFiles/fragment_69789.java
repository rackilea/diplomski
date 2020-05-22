public void setTopicExpression(Expression topicExpression) {
    this.topicExpression = topicExpression;
}

public void setMessageKeyExpression(Expression messageKeyExpression) {
    this.messageKeyExpression = messageKeyExpression;
}

public void setPartitionIdExpression(Expression partitionIdExpression) {
    this.partitionIdExpression = partitionIdExpression;
}

/**
 * Specify a SpEL expression to evaluate a timestamp that will be added in the Kafka record.
 * The resulting value should be a {@link Long} type representing epoch time in milliseconds.
 * @param timestampExpression the {@link Expression} for timestamp to wait for result
 * fo send operation.
 * @since 2.3
 */
public void setTimestampExpression(Expression timestampExpression) {
    this.timestampExpression = timestampExpression;
}