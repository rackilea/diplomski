public class ImgClass {
    private NumFiles numFiles; // choice 2,3,4
    // private NumFiles numFiles = new NumFiles(); // choice 1

    public ImgClass(NumFiles numFiles) { //choice 2
        this.numFiles = numFiles;
    }

    public ImgClass() { //choice 3
        this.NumFiles = new NumFiles();       
    }

    //public ImgClass() { //choice 1 or 4
    //}

    public void setNumFiles(NumFiles numFiles) { //choice 4
        this.numFiles = numFiles;
    }
}