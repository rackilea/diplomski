FileWriter fw = new FileWriter("c:\\example.txt");

        JsonGenerator gen = Json.createGenerator(fw);
        JsonGenerator mainObj = gen.writeStartObject(); //create your start object from the generator

        mainObj.write("object1", 10); //write value:key pairs as needed
        mainObj.write("object2", 1);
        mainObj.write("object3", 11);
        mainObj.write("object4", 11);
        mainObj.write("object5", 12); 

        JsonGenerator loop1 = mainObj.writeStartArray("Loop1"); //When needing to create a new 
                                                               //Array create a new start array                                                                                         
       for(int i = 0; i < 2; i++)     //based on the parent Object/Array, in this case "mainObj."
          loop1.write(5);            //could method chain

        loop1.writeEnd(); //in this case I did not need to create a new  
                          //object for each as I have only one element.

        JsonGenerator loop2 = mainObj.writeStartArray("Loop2"); //same as above to create Array.
        JsonGenerator loopObj2;                                //create new object 


        for(int i = 0; i < 9; i++)
        {

           loopObj2 = loop2.writeStartObject();         //using method-chaining with inner object
                   .write("LoopItem1",10)               //creates an object each time from loop2.
                   .write("LoopItem2",12).writeEnd();   //note method-chaining doesn't have to be 
                                                        //used here
              /*loop2.writeStartObject()                //If we switched to using this code we 
                .write("LoopItem1",10)                  //would be stuck with method-chaining.    
               .write("LoopItem2",12).writeEnd();*/     //loopObj2 isn't needed technically.

        }
        loop2.writeEnd();

        JsonGenerator loop3 = mainObj.writeStartArray("Loop3"); //same as above
        JsonGenerator loopObj3; //same as above

         for(int i = 0; i < 3; i++)
        {
             loopObj3 = loop3.writeStartObject(); //create new object from loop3.
                                                 //note this is exactly the same as above, we 
                                                //just don't use method chaining here, even                 
                                               //though we could chain the first 3



            loopObj3.write("LoopItem1", 57);
            loopObj3.write("LoopItem2", 67);
            loopObj3.write("LoopItem3", 0);
            System.out.println("Breaking Method-Chain just to do it...");
            loopObj3.write("LoopItem4", 9);
            loopObj3.writeEnd();                
        }

        loop3.writeEnd();
        mainObj.writeEnd();
        gen.close();