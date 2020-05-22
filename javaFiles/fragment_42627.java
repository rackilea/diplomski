File file=new File("D://folderName");
File files[]=  file.listFiles();
for(File f:files){
    if(f.getName().contains("search word")){
        System.out.println(f.getName());
    }
}