String line;
while((line = br.readLine()) != null) {
    text += line;
    if (line!=null){
        text +=  "\n";
    }
}