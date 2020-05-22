double i;
    double getal = 0;
    //in this example we need to start the count at -1 since we are going to be counting the '0'
    int tellen  = -1; 

    Scanner input = new Scanner(System.in);

    do{
            System.out.println("Volgenge getal");
            i = input.nextDouble();
            getal = getal + i;
            //we need to increment our count down here so the '0' doesnt count
            tellen++;
       }while(i != 0);

    System.out.println("Gemiddelde is " + getal / (tellen));
    input.close();
}