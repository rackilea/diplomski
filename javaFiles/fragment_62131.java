for(File f : listOfFiles) {
     String fileName = f.getName();
     fileName = fileName.replaceAll("\\.zip", "");
     fileName = fileName.replaceAll("\\[", "");
     fileName = fileName.replaceAll("]", "");

     bw.write(fileName);
     bw.newLine();
}