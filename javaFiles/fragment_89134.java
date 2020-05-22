public void readDir(File f){
    File subdir[] = f.listFiles();
    for(File f_arr : subdir){
        if(f_arr.isFile() && f_arr.getName().endsWith(".jpg")){
            this.readFile(f_arr);
        }
        if(f_arr.isDirectory()){
            this.readDir(f_arr);
        }
    }
}