public static void main(String[] args){
method();

boolean x = true;
    if(x == y()){
       System.out.println("You're right!");

    }else{
        System.out.println("You're wrong!");
        main(args);
  }
}


public static void method(){
    System.out.println("a+b=5 If a=2 what does b equal?"); 
}
public static boolean y(){
    try{
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int input2 = Integer.parseInt(input);
        int b = 3;
        return input2 == b;
}

        catch( Exception e ) {
            return false;
  }
 }
}