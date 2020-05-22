public static void main(String[] args) {

    String echo = null;
    if(args.length == 1){
        echo = "Your name is " + args[0];
    }else{
        echo = "Wrong number of arguments!";
    }

    System.out.println(echo);

}