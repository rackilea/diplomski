for (int i = 0 ; i < nameArray.length ; i++) {
    System.out.println ("Please enter a race participant Name for runner " + (i+1) );
    nameArray[i] = input.next();
    System.out.println ("Please enter a race result for runner " + (i+1) );
    resultArray[i] = input.nextDouble();
}