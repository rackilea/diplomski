static File dir = new File("images");
static File imgList[] = dir.listFiles();

public static void listFiles(String imageName) {

    if(dir.isDirectory()){
        for(File img : imgList){
            if(img.isFile()){
            MakeGrey.makeGrey(img);
        }
    }
}