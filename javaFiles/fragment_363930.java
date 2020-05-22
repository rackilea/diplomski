BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
 do {
     try {
         System.out.print("Please enter the building number: "); 
         userbnumber = obj.readLine();
         if(!usernumber.equals("0"){
         //perform action here
         }
     } catch (IOException e) { 
         //handle it
     }
 } while(!userbnumber.equals("0"));