LineNumberReader lnr = new LineNumberReader(new FileReader(f));
String line = "";
while(line != null){
    line = lnr.readLine();
    if(line==null){break;}
    /* do stuff */
}