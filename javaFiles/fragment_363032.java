public static void myMethod() {

    Scanner in = new Scanner(System.in);
    int array[] = new int[21];
    int number=0;

    boolean end = false;

    while (!end) {


        System.out.println("Please give an number between 0-20: ");
        //check symbol
        try{
            number = Integer.valueOf(in.next());
        }catch(Exception e)
        {
            System.out.println("It's not a number! ");
            continue; //skip loop
        }

        if((number>=0)&&(number<=20))
        {
              System.out.println(array[number]);
              end=true;
        }
        else
             System.out.println("I cant find number " + number
                        + " in the array, please try again ");

        /* why do you use loop here???
         * u need to check if number between 0-20
        for (int i = 1; i < array.length; i++) {

            if (i == number) {

                System.out.println(array[number]);
                end = true;
            }
        }*/


    }

 }