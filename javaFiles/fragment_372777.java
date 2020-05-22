public void checkLogin(String user, String pass) throws FileNotFoundException{
        this.readLines();


        if (tries == 0){
            System.out.println("YOU HAVE TRIED TOO MANY TIMES!");
            return;
        }  
        int i = 0;
        for(; i < this.usernames.size(); i++) {
              if (!this.usernames.contains(user)) 
                  continue;

               if (passwords.get(i).equals(pass)) {
                   System.out.println("SUCCESSFUL, YOU ARE LOGGED IN!");
                   break;
               }            
        }
        if (i == this.usernames.size())
            System.out.println("USERNAME OR PASSWORD INCORRECT! TRY AGAIN");
  }