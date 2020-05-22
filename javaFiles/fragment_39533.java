try{
    String strSchActStartTime = inData.getTransactionDetails().get("Schedule Actual Start Time");
    if (strSchActStartTime == null) {
      //logger.debug("Schedule Actual Start Time is null "); //need to send this as an EXCEPTION in the response.
      throw new NullPointerException("Schedule Actual Start Time is null");
    }
    String strSchActEndTime = inData.getTransactionDetails().get("Schedule Actual End Time");
    if (strSchActEndTime == null) {
      logger.debug("Schedule Actual End Time is null "); //need to send this as an EXCEPTION in the response.
    }
    String breakStr = inData.getTransactionDetails().get("Break String");
    String newValue = "\"EMPSKD_ACT_START_TIME" + slot + "=" + strSchActStartTime.trim() + "\"";
    newValue = newValue + ",\"EMPSKD_ACT_END_TIME" + slot + "=" + strSchActEndTime.trim() + "\"";
    if (breakStr != null) {
      newValue = newValue + ",\"EMPSKD_BRKS=" + breakStr.trim() + "\"";
    }
    ovr.setOvrNewValue(newValue);
    logger.debug("Schedule New Value : " + newValue);
    oa.insert(ovr);
} catch (NullPointerException npe){
   //Code to handle the error
}