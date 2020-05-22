@Override
public void run() {
   while(client.isConnected()) {  //client.isConnected should be a method of your client class
      Object inputData = in.read(); //you should use a proper Object type here, if you
                                    //use InputStreamReader, it would be Byte and if you
                                    //use BufferedReader it would be String
      doCrazyStuff(inputData);      //just an example of manipulating data, do your own stuff here
   }
}