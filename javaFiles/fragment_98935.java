BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
int lines = 0;
String line;
while ((line = reader.readLine()) != null){
    if(!"".equals(line.trim())){
        lines++;
    }
}