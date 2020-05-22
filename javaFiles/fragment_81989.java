String fileNameNoExt=fileName.substring(0, fileName.lastIndexOf('.'));
//fileName is .txt file name
File file = new File(afpSRC, afpName);
if (!file.exists()){
   throw new RuntimeException("file not found = " + file);
}

boolean isRenamed = file.renameTo(new File(afpSRC, fileNameNoExt + ".afp"));
System.out.println("isRenamed = " + isRenamed);
if (!isRenamed){
   // handle the problem
}