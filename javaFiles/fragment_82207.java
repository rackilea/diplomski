public static void main (String[] args) {
    Scanner lector = new Scanner(System.in);
    int valorUsuari = 0;
    int counter = 0; //this is your counter, it starts at 0 because the user has failed 0 times at this point
    boolean valorNOk=true;
    while (valorNOk && counter < 3){
        System.out.print("Insert a number between 0 and 5: ");
        valorUsuari = lector.nextInt();
        lector.nextLine();
        if((valorUsuari >= 0)&&(valorUsuari <= 5)){
          valorNOk=false;    
        } else {
            counter++; //this is added to keep track of failed tries
        }
    }
    System.out.println("Data correct. You typed " + valorUsuari);
}