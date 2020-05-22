SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor
    .create(SimpMessageType.MESSAGE);
headerAccessor.setSessionId(sessionId);
headerAccessor.setLeaveMutable(true);

messagingTemplate.convertAndSendToUser(sessionId,"/queue/something", payload, 
    headerAccessor.getMessageHeaders());