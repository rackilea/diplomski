public static void main(String[] args) {
     User myuser= registerUser("John", "Doe", "Username", "Password");
      boolean hasExit = true;
      while (hasExit)
      {
         String options = "";
         options = JOptionPane.showInputDialog("The following actions are 
   supported. Enter the code: \nA: Login\nB: Print Users\nC: Exit");
         if (options.equalsIgnoreCase ("A"))
         {
            String username = JOptionPane.showInputDialog("Username");
            String password = JOptionPane.showInputDialog("Password");
            // I would like to check whether the username and password 
      // submitted here are the same as the one used to register  
            // Use userLogin method here to compare the username and password 
    //that is inputted here and the username and password that was created 
    //when registering
            if(myuser.getUsername().equals(username) && 
      myuser.getPassword.equals(password)) { 
                // this is for only created user object by using registerUser 
        // method
                // if you want to check in complete list need to iterate list 
            // here, by using for each or streams 
                System.out.println("user existed or success ");
                hasExit = false;
            }else {
                System.out.println("failed");
                hasExit = false;
            }
         }
         else if (options.equalsIgnoreCase ("B"))  
         {
            listUsers();
           hasExit = false;
         }      
         else if (options.equalsIgnoreCase ("C"))
         {
            hasExit = false;
         }
      }  

   }