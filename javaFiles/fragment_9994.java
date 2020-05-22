public void getNumGroupsOfSize() {
    int cnt = 1;
    int currentNumber = numArray[0];
    for (int x = 0; x < numArray.length - 1; x++) {
        if (numArray[x] == numArray[x + 1]){
            cnt++;
        }
        else{
            System.out.println(currentNumber + ": " + cnt);
            currentNumber=numArray[x+1];
            cnt=1;
        }
    }
    System.out.println(currentNumber + ": " + cnt);

}