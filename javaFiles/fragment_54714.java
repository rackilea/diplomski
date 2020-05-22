String theSummary = location + " has zip codes: " + setZipCodes();
 String theNewSummary = "";
 for(int i = 0; i < theSummary.length()-1; i = i+100){
          if(i+99 < theSummary.length()-1)
          theNewSummary += theSummary.substring(i, i+99)+"\r\n";
          else
           theNewSummary += theSummary.substring(i, theSummary.length()-1);

 }
 System.out.print(theNewSummary );