public void run() {
   while(client.isConnected()) {  //client.isConnected should be a method of your client class
      while(!in.ready()) { }        //here you CAN use the method ready, that is boolean

      String inputData = in.readLine();
      doCrazyStuff(inputData);      //just an example of manipulating data, do your own stuff here
   }
}