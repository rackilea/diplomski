for(File f : new File("").listFiles()) {
     String fileName = f.getName();
     fileName = fileName.replaceAll("\\.zip|\\[|]", "");

     bw.write(fileName);
     bw.newLine();
}