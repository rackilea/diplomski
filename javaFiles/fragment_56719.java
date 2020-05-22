File inFile = new File("C:\\Users\\name\\Documents\\workspace\\Testing\\src\\receiver.txt");
Scanner sc=new Scanner(inFile);//unchanged
char[] alpha =  {'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'}; 
PrintWriter outStream=new PrintWriter("C:\\Users\\name\\Documents\\workspace\\Testing\\src\\caesar.txt");
//rest of code is identical
/*
receiver.txt (input file):
<?xml version="1.0" encoding="UTF-8"?>
<tradeevent>
   <event>
      <eventId>612</eventId>
      <relatedId>0</relatedId>
      <operationalEventIndicator></operationalEventIndicator>
      <effectiveDate>2012-08-07T11:20:47.09</effectiveDate>
      <id>612</id>
      <createdOnDate>0</createdOnDate>
   </event>
   <trade>
...
caesar.txt (created output file):
<? FJ="1.0" FDEJH="G-8"?>
<EFFF>
   <FF>
      <FFJE>612</FFJE>
      <FFEJE>0</FFEJE>
      <FJFFJEJD></FJFFJEJD>
      <FGGFDJFEF>2012-08-0711:20:47.09</FGGFDJFEF>
      <JE>612</JE>
      <DFFEEF>0</DFFEEF>
   </FF>
   <EF>
...
*/