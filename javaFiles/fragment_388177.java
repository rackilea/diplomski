public static int summation(int lower, int upper){
    if (lower > upper) {
        System.out.println("Returning: 0");               // print before return
        return 0;
    } else{
        int result = lower + summation(lower+1, upper);

        System.out.println("Current lower bound: " + lower);
        System.out.println("Upper bound: " + upper);
        System.out.println("Returning: " + result);       // print before return
        return result;
    }
}