File Readfile= new File(n.getProperty("file"));
BufferedReader reader= new BufferedReader(new FileReader(Readfile));
Set<String> lines = new HashSet<String>(10000);
String line;
while((line=reader.readLine())!=null){
    lines.add(line);
}
reader.close();
File file =new File("stripduplicates.txt");

if(!file.exists()){
    file.createNewFile();
}
BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath()));
   //EDIT done
    writer.write("DETAILS:");
for(String unique: lines){
    //EDIT done
      if(!(unique.startsWith("DETAILS:"))
        {
        writer.write(unique);
        writer.newLine();
        }
}
writer.close();
}