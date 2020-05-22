try{
    // Method 1:
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(reader);
    System.out.println("Type text 1: ");
    String line = buffer.readLine();
}catch(Exception e){
  //handle error
 }