public static void main(String[] args) {
    // TODO Auto-generated method stub

    System.out.println("Enter speed:");
    int speed = IO.readInt();
    if (speed < 0){
        System.out.println("Speed cannot be negative. Try again.");
        }
   else if (speed <=60){
        System.out.println("$0");
    }else if (speed > 60 && speed <=75){
        System.out.println("$100");
    }else if (speed > 75 && speed <=90){
        System.out.println("$500");
    }

}