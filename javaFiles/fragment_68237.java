ArrayList<String> deckList = new ArrayList<String>(Arrays.asList(deck));//Changing Array with card contents into an ArrayList


while (deckComplete == false) {         //While loop for dealing cards


    for (int j = deckList.size()-1; j > 0; j-=2) {


       // System.out.println("Hit enter to be dealt a card!");    
        String readString = scanner.nextLine(); //Set variable "readString" to user input

        if (readString.equals("")) {        //If user input equals "enter"...

            Collections.shuffle(deckList, new Random());

            if (j == 1) {   //If program gets to last card...
                   deckComplete = true; //Set desk complete to true

                   System.out.println(deckList.get(0));
                   System.out.println(deckList.get(1));//Print last card
                    System.out.println("You are out of cards!"); //Print "You are out of cards"
                   break; //Stop loop
               }    
                    System.out.println(deckList.get(0)); //Print first card
                    deckList.remove(0); //Remove card
                    System.out.println(deckList.get(0)); //Print next card
                    deckList.remove(0); //remove card

           }



   }