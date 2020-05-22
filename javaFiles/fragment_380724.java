public static void main(String[] args) {
    String bosted=""; //Variable
    String navn=""; //Variable

    Scanner in = new Scanner(System.in);

    System.out.println("Skriv inn navn: "); //What shows up when you first start the program

    while(in.hasNext()) { //Only allow letters A-Z
         navn = in.nextLine();
        if(!navn.isEmpty() && navn.matches("[A-Za-z]+")){
             System.out.println("Takk!"); //Says thank you if the user has entered letters
             in.next();
             break;
        }
        else{
            System.out.println("Tall horer ikke hjemme i navn, prøv igjen!"); //Prints, "numbers dont belong in names, try again" if what the user entered is a number
            in.next();
            System.out.println("Skriv inn navn: ");
            continue;
        }

  }

    System.out.println("Skriv inn bosted: ");
    while(in.hasNext()) { //Only allow letters A-Z
        bosted = in.nextLine();
       if(!bosted.isEmpty() && bosted.matches("[A-Za-z]+")){
         System.out.println("Takk!"); //Says thank you if the user has entered letters
         break;
       }
       else{
           System.out.println("Tall horer ikke hjemme i navn, prøv igjen!"); //Prints, "numbers dont belong in names, try again" if what the user entered is a number
           in.next();
           System.out.println("Skriv inn bosted: ");
           continue;
       }


 }
    System.out.println("Hei, " + navn + "! Du er fra " + bosted + "."); //Prints out what the user has entered previously in a full sentence.
}