public void onMessage(Message msg) {
    try {
        AQjmsAdtMessage aQjmsAdtMessage = (AQjmsAdtMessage) msg;
        OracleAQObjORADataFactory obj = (OracleAQObjORADataFactory) aQjmsAdtMessage.getAdtPayload();

        System.out.println("Datetime: " + obj.getId());
        System.out.println("Payload: " + new String(obj.getPayload(), Charset.forName("UTF-8")));
    }
    catch (Exception jmsException) {
        if (logger.isErrorEnabled()) {
            logger.error(jmsException.getLocalizedMessage());
        }
    }
}