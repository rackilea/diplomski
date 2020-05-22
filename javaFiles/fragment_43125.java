while(scan.hasNextLine()){
    String dnaSequence = scan.nextLine().toUpperCase();

    for (int i = 0; i < dnaSequence.length(); i++){
        validCount = dnaSequence.charAt(i);
        switch (validCount){
        case 'A' :
            countA++;
            break;
        case 'T' :
            countT++;
            break;
        case 'C' :
            countC++;
            break;
        case 'G' :
            countG++;
            break;
        }
    }
}