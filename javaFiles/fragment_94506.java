private static JsonObject buildNotificationMessage() {
    JsonObject jNotification = new JsonObject();
    jNotification.addProperty("title", "TITLE");
    jNotification.addProperty("body", "BODY");

    JsonObject jMessage = new JsonObject();
    jMessage.add("notification", jNotification);
    jMessage.addProperty("to", "e1ltVa_...CVOKg6D5");

    //JsonObject jFcm = new JsonObject();  // <= NOT NEEDED
    //jFcm.add("message", jMessage);  // <= NOT NEEDED

    return jMessage;  // <= CHANGED
}