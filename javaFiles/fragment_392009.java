ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2016_05_19);
service.setUsernameAndPassword("xxxxxxxxx", "xxxxxxx");
service.setEndPoint("https://gateway.watsonplatform.net/conversation-experimental/api");

MessageRequest newMessage = new MessageRequest.Builder().inputText("Hola").build();
MessageResponse response = service.message("xxxxxxxx", newMessage).execute();
System.out.println(response.getText());