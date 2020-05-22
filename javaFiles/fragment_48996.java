@Test
public void testMessageMandatoryAttributes() {
    Message corruptedMessage = new Message();
    // set id
    // corruptedMessage.setId(id);
    // set conversation thread
    // corruptedMessage.setConversationThread(conversationThread);

   try {
       messageRepository.save(corruptedMessage);
       fail();
   catch (YourException e) {
       assertEquals("Expected value", e.getXxx());
       // ...
   }
}