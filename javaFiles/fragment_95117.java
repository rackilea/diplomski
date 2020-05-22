public static void main(String[] args){
    String[] listOfStrings = new String[]{"a","b","c","d","g","h","k","z"};
    String stringToFind = "d";
    int lowestIndex = 0;
    int highestIndex = listOfStrings.length-1;
    int middleIndex = 0;

    while(lowestIndex<=highestIndex){
        middleIndex = (lowestIndex+highestIndex)/2;

        if(stringToFind.compareTo(listOfStrings[middleIndex]) > 0){
            lowestIndex = middleIndex+1;
        }else if(stringToFind.compareTo(listOfStrings[middleIndex]) < 0){
            highestIndex = middleIndex - 1;
        }else{
            break;
        }
    }//end of while
    if(lowestIndex > highestIndex){
        System.out.println("not found");
    }else{
        System.out.println("found at " + middleIndex);
    }
}