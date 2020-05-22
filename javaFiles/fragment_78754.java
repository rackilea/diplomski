public static void main(String[] args) {
    //nubmer elements
    int n = 10;

    while(true){
           int switchToElement = getRandomNumber(n);
           switch(switchToElement) {
           case 0:
               //perform logic related to first element
               break;
           case 1:
               //perform logic related to second element
               break;
            // other cases..

            default:
                //should never reach this line unless there is a problem in your getRandomNumber
           }
        }
}

private static int getRandomNumber(int n) {
    // write logic to generate random number between 0 and n 

}