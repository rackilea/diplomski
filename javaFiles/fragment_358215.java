// ....
String message = "linkSpeed = " + linkSpeed;
Message msg = Message.obtain(); // Creates an new Message instance
msg.obj = message; // Put the string into Message, into "obj" field.
msg.setTarget(handler); // Set the Handler
msg.sendToTarget(); //Send the message
//....