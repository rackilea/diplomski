String fileString = "";
for(int i = 0; i < lines.length; i++){
   lines[i] = lines[i].replace(":", ",");
   lines[i] = lines[i].replace(" ", ",");
   fileString += lines[i];
}