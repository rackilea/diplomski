public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("what number would you like me to multiply: ");
    int number = in.nextInt();
    System.out.println("how many multiples of "+number+" would you like to see: ");
    int multiple = in.nextInt();
    System.out.print("The first " + multiple + " multiples of " + number + " are: ");
    for(int i=1; i<=multiple; i++){
        if(i>1){
            System.out.print(", ");
        }
        System.out.print(number*i);
    }
}