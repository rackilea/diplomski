Scanner keyboard = new Scanner(System.in);

        System.out.print( "Question 1: Does it belong inside or outside or both? ");
        String q1 = keyboard.next();//will not take any value after space


            System.out.println( "Question 2: Is it alive? ");
            String q2 = keyboard.next();//will not take any value after space
 //so if you enter "not alive" q2 will store only "not".
            //String q2 = keyboard.nextLine();
// this will take all character even after space