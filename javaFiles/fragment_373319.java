String[] myData = parseQuotedData("val1 , \"val2 , \" val3, val4\" \" , \" val5,val6 \"");

System.out.println("\nMy Parsed Data String:\n======================");
for (int i = 0; i < myData.length; i++) {
    System.out.println(myData[i]);
}