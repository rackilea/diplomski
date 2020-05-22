public static void main(String[] args) {
    String con;
    List<String> names = new ArrayList<>();
    do{
      menuCaller(names);
      System.out.println("Do you want to continue[Y/N]"); 
      Scanner confirm = new Scanner(System.in);
      con = confirm.nextLine();    
    }while(con.equalsIgnoreCase("y"));
}

public static void menuCaller(List<String> names) {
    ...
    // (No declaration of names here - it's a parameter now...)
    ...
}