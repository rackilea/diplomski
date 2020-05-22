BufferedReader fileIn = ...
String line;
while((line = fileIn.readLine()) != null){
    //do something
}
fileIn.close();