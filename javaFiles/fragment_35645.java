public String readFile(File aFile) throws IOException {

String data = "";

try {
    BufferedReader input =  new BufferedReader(new FileReader(aFile));
    String line = null;
    int cnt = 0;
    String[] topRow = new String[0]; 
    while (( line = input.readLine()) != null){
        if(cnt==0){
            String[] l = line.split(",");
            topRow = new String[l.length-1];
            for(int i= 0; i<l.length-1; i++){
                topRow[i] = l[i+1];
            }
         }
         else{
            String[] l = line.split(",");
            for(int i= 1; i<Math.min(l.length, topRow.length+1); i++){
                if(!l[i].equals("")){
                    String row = "";
                    row = l[0];
                    row = row + " " + topRow[i-1];
                    row = row + " " + l[i];
                    if(data.equals(""))data = row;
                    else data = data + "\n" + row;
                 }
              }
         }
         cnt++;
    }
}
catch (IOException ex){
  ex.printStackTrace();
}
return data;