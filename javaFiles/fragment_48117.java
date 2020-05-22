String msg1="Message from bob 1"; // message
MSGBOB = cipher.doFinal(msg1.getBytes("ISO-8859-1")); // encryption
msg.setContent(Base64.encode(MSGBOB)); // conversion to string
This is how I decrypt it :

mm = Base64.decode(msg.getContent());// received message 
m = new String(cipher.doFinal(mm),"ISO-8859-1"); // decryption