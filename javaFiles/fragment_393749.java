String line = br.readLine();
while (line != null) {
    text += line;
    line = br.readLine();
    if (line!=null){
        text +=  "\n";
    }
}