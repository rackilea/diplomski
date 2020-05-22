int firstNum;
for(int k=0; k<numTests; k++){
    firstNum = rand.nextInt(upperLimit);
    for(int i=1; i<upperLimit; i++){//notice this starts in 1
        n = rand.nextInt(upperLimit);
        if(firstNum == n){
            totalCount += i;//totalCount += i+1 if you are counting the first number
            break;
        }
    }
    System.out.println("Total Count: " + totalCount);
    arrLog.clear();
}   
testAverage = totalCount/numTests;
System.out.println("Average tests before match: " + testAverage);