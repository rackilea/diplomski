int desktopID = 0;
Random randomID = new Random();

// Note that I'm instantiating the list before using it!
List<MessageHandler> test = new Arraylist<>;

for(int i = 0; i < 1000; i++){
    desktopID = randomID.nextInt(10);
    System.out.println(desktopID);

    // Create a MessageHandler object and set the message.
    MessageHandler handler = new MessageHandler();
    handler.storeMessage("Message Number: "+ i, desktopID);        

    // Add that method to your list
    test.add(handler);
}

// This is a foreach loop. Very useful! Will iterate over each element in order.
for(MessageHandler handler : test){
    System.out.println(handler.getRecentMessage(desktopID).toString());
}