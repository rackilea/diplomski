// Have this method accept the data as a parameter
public static void showMoney(int passedMoney){
    System.out.println("Money: " + passedMoney);
}


public static void main(String[] args){
    int money = 1000;

    // Then pass it in here as an argument to the method
    showMoney(money);
}