String theSummary = location + " has zip codes: \r\n";
  String[] zipCodes = setZipCodes().split(" ");
  for(int i = 0; i < zipCodes.length; i++){
       theSummary += " "+zipCodes[i];
       if(i%10 == 0 && i !=0)
           theSummary +="\r\n"
  }
  System.out.print(theSummary );