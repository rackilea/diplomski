String line = null;
String input = "";
while((line=buffreader.readLine())!=null){
    input += line;
}

parts = input.split(";");