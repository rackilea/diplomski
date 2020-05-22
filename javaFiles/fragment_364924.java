String option = console.readLine();

         while(option.equalsIgnoreCase("get balance")){
             System.out.println(account.getBalance());  //go back to the if after this excecutes
             option =  console.readLine();

         }