public static double totalAmount(double probability, int numOfSuccesses){
    double total= 0;
    for (int i = 0; i < numOfSuccesses; i++){
        total += probability;
    }
    return total;
}