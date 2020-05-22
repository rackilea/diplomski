for(String fx:tx_sp)  //your for loop
{                                        
String temparray[]= fx.split("\n");
  for (int x = 1; x < temparray.length;  x++)
  {
    if (temparray[x].contains(words[i]))
    {
     System.out.println(temparray[0]+     // It will have  AnotherData(12)
                        temparray[x]+     // It will have matched line with Find3
                        "END");           // Append an END which is omitted by split method
      break;                              // breaks the loop if Find3 found
    }
  }
}