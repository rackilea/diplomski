public static void main(String[] args){
    NewtonRaphson nr = new NewtonRaphson();

    try {
       System.out.println(nr.squareRoot(2.0));
    } catch (NegativeNumber e) {
       System.out.println("Be more positive!");
    }
}