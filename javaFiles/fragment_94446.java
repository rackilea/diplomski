// My Scanner
 Scanner input = new Scanner(System.in);   
    //using Do While Loop
    do{
        //Asking user to enter email
        System.out.println("enter your email:");
        //Read and safe input in to Var userEmail
        String userEmail = input.next();
        //Check for contains '@' and '.com' simbols
        Pattern pattern = Pattern.compile("\\S+?@\\S+?\\.com");
        //And it checking in users entered email
        Matcher matcher = pattern.matcher(userEmail);
        //if userEmail contain '@'and '.com' print next line
        if (matcher.matches()) {
            System.out.println("Matches"); // Prints this for this email    
        }
        //if user put email with out '@'and'.com' print next line
        else{
            System.out.println("your email should 
            looks like this sample bob.Dillon@gmail.com");
        }
    //And here I have a problem don't know what to type in so that it starts looping until user input will be 100% correct 
    }while(INPUTVALUE.length > 0);