String currentLine;
String[] line  = new String[15];
String[] line2 = new String[15];
int i = 0;
while(line != null && !currentLine.equals("@")){
    line = MyReader.readLine().split("");
    currentLine = line[i];
    if(currentLine.equals("@")) line[i] = null;
    i++;
}
while(line2 != null)){
    line2 = MyReader.readLine().split("");
}