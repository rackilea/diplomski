out.println(console.readLine());                //Client initiates (sent to server)

    while ((userOut = in.readLine()) != null)       //Waits for response
    {
        System.out.println("Server says: " + userOut);  //Prints response

        if(!in.available()){
          userIn = console.readLine();                //Gets user input
          out.println(userIn);                        //Sends user input to server
        }
    }