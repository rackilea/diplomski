public void getValue(String nodeName, NodeId registeredNodeId, UaClient client) {

    try {
        DataValue value = null;
        try {
            value = client.readAttribute(registeredNodeId, Attributes.Value);
        } catch (ServiceException | StatusException e1) {
            e1.printStackTrace();
        }

        TeocModel curTeocModel = new TeocModel(value.getSourceTimestamp().getTimeInMillis(), nodeName, value);
        KafkaStreamer.getInstance().startStreaming(curTeocModel.toJson());

    } catch (Exception e) {
        fileLogger.error(e.getMessage());
    }
}