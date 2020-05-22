File dir = new File("directory/of/.tar.gz/files/here");
File listDir[] = dir.listFiles();
if (listDir.length!=0){
    for (File i:listDir){
        /*  Warning! this will try and extract all files in the directory
            if other files exist, a for loop needs to go here to check that
            the file (i) is an archive file before proceeding */
        if (i.isDirectory()){
            break;
        }
        String fileName = i.toString();
        String tarFileName = fileName +".tar";
        FileInputStream instream= new FileInputStream(fileName);
        GZIPInputStream ginstream =new GZIPInputStream(instream);
        FileOutputStream outstream = new FileOutputStream(tarFileName);
        byte[] buf = new byte[1024]; 
        int len;
        while ((len = ginstream.read(buf)) > 0) 
        {
            outstream.write(buf, 0, len);
        }
        ginstream.close();
        outstream.close();
        //There should now be tar files in the directory
        //extract specific files from tar
        TarArchiveInputStream myTarFile=new TarArchiveInputStream(new FileInputStream(tarFileName));
        TarArchiveEntry entry = null;
        int offset;
        FileOutputStream outputFile=null;
        //read every single entry in TAR file
        while ((entry = myTarFile.getNextTarEntry()) != null) {
            //the following two lines remove the .tar.gz extension for the folder name
            String fileName = i.getName().substring(0, i.getName().lastIndexOf('.'));
            fileName = fileName.substring(0, fileName.lastIndexOf('.'));
            File outputDir =  new File(i.getParent() + "/" + fileName + "/" + entry.getName());
            if(! outputDir.getParentFile().exists()){ 
                outputDir.getParentFile().mkdirs();
            }
            //if the entry in the tar is a directory, it needs to be created, only files can be extracted
            if(entry.isDirectory){
                outputDir.mkdirs();
            }else{
                byte[] content = new byte[(int) entry.getSize()];
                offset=0;
                myTarFile.read(content, offset, content.length - offset);
                outputFile=new FileOutputStream(outputDir);
                IOUtils.write(content,outputFile);  
                outputFile.close();
            }
        }
        //close and delete the tar files, leaving the original .tar.gz and the extracted folders
        myTarFile.close();
        File tarFile =  new File(tarFileName);
        tarFile.delete();
    }
}