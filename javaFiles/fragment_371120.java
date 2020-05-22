public void loadPic(){//open up all of the images and store them in an ArrayList


    String youDirectory="img/youImgs/";
    File folder = new File(youDirectory);
    File[] listOfFiles = folder.listFiles();

    for(int i=0;i<listOfFiles.length;i++){
        youImgs.add(new ArrayList<BufferedImage>());
    }

    for(int h=0;h<listOfFiles.length;h++){
        File file=listOfFiles[h];
        if(file.isDirectory()){
            try{
                youMoves.add(file.getName());
                File folder2=new File(youDirectory+file.getName()+"/");
                File[]listOfFiles2=folder2.listFiles();
                for (int i = 0; i < listOfFiles2.length; i++){
                    File file2 = listOfFiles2[i];
                    if (file2.isFile() && file2.getName().endsWith(".png")){
                            youImgs.get(h).add(ImageIO.read(new File(youDirectory+file.getName()+"/"+file2.getName())));
                    }
                }
            }
            catch(IOException e){}
        }
    }
}