private static PushNotificationPayload createPayload(JSONObject jsonObject)
        throws JSONException {

    String alertMsg = Common.getStringUnicodeAsNull1(jsonObject,
            AppConstants.FLD_ALERT_MSG);
    byte[] emojiBytes=null;
    String text=null;
    try {
        emojiBytes = alertMsg.getBytes("UTF-8");
        text = new String(emojiBytes, "UTF-8");
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    //String emojiAsString = new String(emojiBytes, Charset.forName("UTF-8"));
    //System.out.println("@@@@@alertMsg: "+text);
    Integer badgeCnt;
    if (jsonObject.has(AppConstants.FLD_BADGE_CNT)){
        badgeCnt = Common.getIntegerAsNull(jsonObject,
                AppConstants.FLD_BADGE_CNT);
    }else{
        badgeCnt = AppConstants.VAL_ZERO;
    }
    PushNotificationPayload payload = createPayload(badgeCnt, text);
    return payload;
}