public static void inputPass( Scanner input,  Passenger[] passenger ,File fin ) throws IOException{
    if (indexPassenger<passenger.length)  {
       passenger[indexPassenger]=new Passenger();
       String name=input.next();//Taking ADD_PASS instead of Salwa
        passenger[indexPassenger].setname(name);
            int age=input.nextInt();//Trying to take an integer but found string Salwa thus occurred InputMisMatchException. 
        passenger[indexPassenger].setage(age);
            char gender=input.nextLine().charAt(0);
        passenger[indexPassenger].setgender(gender);
                String d=input.next();
                      passenger[indexPassenger].setphone(d);

    indexPassenger++;

    }}