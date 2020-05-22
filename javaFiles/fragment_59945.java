double i;
    double getal = 0;
    int tellen  = 0;

    Scanner input = new Scanner(System.in);

    while(true) {
            System.out.println("Volgenge getal");
            i = input.nextDouble();
            getal = getal + i;
            if(i == 0){
                //break statements end the loop
                break;
            }
            //we need to increment our count down here so the '0' doesnt count
            tellen++;
        }

    System.out.println("Gemiddelde is " + getal / (tellen));
    input.close();
}