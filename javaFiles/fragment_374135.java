class ClientExample{  
  public static void main(String args[]){  
    System.out.println("Your first argument is: "+args[0]);
    System.out.println("Your second argument is: "+args[1]);
    System.out.println("Your third argument is: "+args[2]);
    String serverIP = args[0];
    int serverPort = Integer.parseInt(args[1]);
    String commandFile = args[2];
  }  
}