public void enqueueMessage(OracleConnection conn, String correlationId, byte[] payloadData) throws Exception {
    // First create the message properties:
    AQMessageProperties aqMessageProperties = AQFactory.createAQMessageProperties();
    aqMessageProperties.setCorrelation(correlationId);
    aqMessageProperties.setExceptionQueue(EXCEPTION_QUEUE_NAME);

    // Specify an agent as the sender:
    AQAgent aqAgent = AQFactory.createAQAgent();
    aqAgent.setName(SENDER_NAME);
    aqAgent.setAddress(QUEUE_NAME);
    aqMessageProperties.setSender(aqAgent);

    // Create the payload
    StructDescriptor structDescriptor = StructDescriptor.createDescriptor(EVENT_OBJECT, conn);
    Map<String, Object> payloadMap = new HashMap<String, Object>();
    payloadMap.put("ID", correlationId);
    payloadMap.put("PAYLOAD", new OracleAQBLOBUtil().createBlob(conn, payloadData));
    STRUCT struct = new STRUCT(structDescriptor, conn, payloadMap);

    // Create the actual AQMessage instance:
    AQMessage aqMessage = AQFactory.createAQMessage(aqMessageProperties);
    aqMessage.setPayload(struct);

    AQEnqueueOptions opt = new AQEnqueueOptions();
    opt.setDeliveryMode(AQEnqueueOptions.DeliveryMode.PERSISTENT);
    opt.setVisibility(AQEnqueueOptions.VisibilityOption.ON_COMMIT);

    // execute the actual enqueue operation:
    conn.enqueue(QUEUE_NAME, opt, aqMessage);
}