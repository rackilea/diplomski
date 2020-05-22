try{
   BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
   String name= cin.readLine();

    if(name!=null && name.equals("jon")) {
        System.out.println("hello, jon.");
   } else {
        System.out.println("hello, guest.");
   }
 }catch(IOException e){

 }