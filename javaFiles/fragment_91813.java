// list of numbers that I already picked
ArrayList<Integer> randomNumbersPicked = new ArrayList<>();
// int to save the current random number
int myCurrentRandomNumber;

while(iNeedAnotherNumber){
    do {
        myCurrentRandomNumber = generateRandomNumber(a, b);
    //repeat this until the number is not in the list
    } while (randomNumbersPicked.contains(new Integer(myCurrentRandomNumber)));
    //here there is a unique random number, do what you will
    System.out.println("A new number has been picked: " + myCurrentRandomNumber);
    //add the number to the list so it wont be picked again
    randomNumbersPicked.add(new Integer(myCurrentRandomNumber));
}