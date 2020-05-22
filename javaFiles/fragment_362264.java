public static void inputPass( Scanner input,  Passenger[] passenger ,File fin ) throws IOException{
    if (indexPassenger<passenger.length)  {
       String not_in_use=input.next();//avoiding ADD_PASS
       passenger[indexPassenger]=new Passenger();
       String first_name=input.next();//taking first name
       String last_name=input.next();//taking last name
        passenger[indexPassenger].setname(first_name+" "+last_name);
            int age=input.nextInt();//taking age
        passenger[indexPassenger].setage(age);
            String gender=input.next();//taking gender
        passenger[indexPassenger].setgender(gender.toCharArray()[0]);
                String d=input.next();//taking phone number
                      passenger[indexPassenger].setphone(d);

    indexPassenger++;

    }}