String[] sArray= S.split(",");
//now sArray contains all the values
String indexList= null;
for(int i=0;t<sArray.length;i++){
 sArray[i]= "'"+sArray[i]+"'";
 indexList= indexList + sArray[i];
 }
 //with 'a' sArray