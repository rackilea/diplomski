protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // Return if push notification is not enabled
    if (!backendConfigManager.isPushEnabled()) {
      log.info("ProspectiveSearchServlet: couldn't send push notification because it is disabled.");
      return;
    }

    // dispatch GCM messages to each subscribers
    String[] subIds = req.getParameterValues("id");
    // Each subId has this format "<regId>:query:<clientSubId>"
    for (String subId : subIds) {
      String regId = SubscriptionUtility.extractRegId(subId);
      if (isSubscriptionActive(regId)) {
        Entity matchedEntity = ProspectiveSearchServiceFactory.getProspectiveSearchService().getDocument(req);
        if(matchedEntity != null) {
            log.info(String.format("ProspectiveSearchServlet: matchedEntity.toString: " + matchedEntity.toString())); 
        } else {
            log.info(String.format("ProspectiveSearchServlet: matchedEntity is null.")); 
        }
        //Add the matchedEntity object.
        sendPushNotification(regId, subId, matchedEntity);
      } else {
        SubscriptionUtility.clearSubscriptionAndDeviceEntity(Arrays.asList(regId));
      }
    }

  }

  private void sendPushNotification(String regId, String subId, Entity matchedEntity) throws IOException {
    SubscriptionUtility.MobileType type = SubscriptionUtility.getMobileType(subId);

    if (SubscriptionUtility.MobileType.ANDROID == type) {
      sendGcmAlert(subId, regId, matchedEntity);
    } else if (SubscriptionUtility.MobileType.IOS == type) {
      sendIosAlert(subId, new String[] {regId}, matchedEntity);
    }
  }


  private void sendGcmAlert(String subId, String regId, Entity matchedEntity)
      throws IOException {
    String gcmKey = backendConfigManager.getGcmKey();
    boolean isGcmKeySet = !(gcmKey == null || gcmKey.trim().length() == 0);

    // Only attempt to send GCM if GcmKey is available
    if (isGcmKeySet) {
      Sender sender = new Sender(gcmKey);

      if(matchedEntity != null) {
          Message message = new Message.Builder().addData(SubscriptionUtility.GCM_KEY_SUBID, subId)
                    //extra data.<key> elements can be added here
                    .addData("data.message", (String) matchedEntity.getProperty("message"))
                    .addData("data.updatedBy", (String) matchedEntity.getProperty("_updatedBy"))
                    .addData("data.owner", (String) matchedEntity.getProperty("_owner"))
                    .addData("data.kindName", (String) matchedEntity.getProperty("_kindName"))
                    .build();

          Result r = sender.send(message, regId, GCM_SEND_RETRIES);
          if (r.getMessageId() != null) {
            log.info("ProspectiveSearchServlet: GCM sent: subId: " + subId);
          } else {
            log.warning("ProspectiveSearchServlet: GCM error for subId: " + subId +
                ", senderId: " + gcmKey + ", error: " + r.getErrorCodeName());
            ArrayList<String> deviceIds = new ArrayList<String>();
            deviceIds.add(regId);
            SubscriptionUtility.clearSubscriptionAndDeviceEntity(deviceIds);
          }
      }  
    } else {
      // Otherwise, just write a log entry
      log.info(String.format("ProspectiveSearchServlet: GCM is not sent: GcmKey: %s ", 
          isGcmKeySet));
    }
  }