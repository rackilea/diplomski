Scanner s = new Scanner(new File("oldLinesFilePath"));
List<String> oldLines = new ArrayList<String>();
List<String> newLines = new ArrayList<String>();

while (s.hasNext()){
    oldLines.add(s.nextLine());
}

s = new Scanner(new File("newLinesFilePath"));

while (s.hasNext()){
    newLines.add(s.nextLine());
}    
s.close();

for(int i = 0; i < newLines.size(); i++) {
   if(!oldLines.contains(newLines.get(i)) {
       System.out.println(newLines.get(i));
   }
}