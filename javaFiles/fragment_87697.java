while(b==false){
       System.out.print("Login: ");
       inputUsr=keyboard.nextLine();
       System.out.print("\nPassword: ");
       String inputPass=keyboard.nextLine();
       if(inputPass.equals(userPass.get(inputUsr))) {
           b=true;
       } else { 
          System.out.println("Either the username
            or password is incorrect. 
                      You have "+(3-tries)+" more attempts.");
                    tries++;
        }
        if(tries>3){
            System.exit(0);
        }
}