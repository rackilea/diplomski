class RefCount {
    String fileId;
    int count;
    RefCount( fileId ){
        this.fileId = fileId;
        count = 1;
    }
    void increment(){
        count++;
    }
    // more...
}