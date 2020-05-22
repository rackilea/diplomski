String sentence = "Test i two II three iIi";        
int iCounter = 0;
String iCount = "iI"; 
for (int j = 0; j < sentence.length(); j++){
    char current = sentence.charAt(j);
    char previous; //1
    if (j==0) { 
        previous = 'Z';  //2
    } else {
        previous = sentence.charAt(j-1); //3
    }
    if (iCount.indexOf(current) != -1 && iCount.indexOf(previous) == -1 ){ //4
        iCounter++;
   }
}