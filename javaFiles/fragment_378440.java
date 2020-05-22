for(int k=0; k<numTests; k++){   
    for(int i=0; i<upperLimit; i++){
        arrLog.insert(n);
        if(arrLog.getElement(0) == n && i != 0){// i != 0 to prevent it from counting a match on the first iteration
            totalCount += i;//totalCount += i+1 if you are counting the first number
            break;
        }
        n = rand.nextInt(upperLimit);
    }
    System.out.println("Total Count: " + totalCount);
    arrLog.clear();
}   
testAverage = totalCount/numTests;
System.out.println("Average tests before match: " + testAverage);