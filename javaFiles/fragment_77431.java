public class GetUploadFiles {
    private static String[] arguments;

    public GetUploadFiles(String[] args){
         arguments=args;   
    }

    /**
     * start the process of creating and uploading the zip file according to the arguments passed to the constructor
     */
    public void upload() throws IOException{
        startProcess()
    }

    public static void main(String[] args) throws IOException {
        new GetUploadFiles(args).upload();
    }

    private void startProcess() throws IOException{
        //my code is here
        //Can just use arguments in here since class is no longer static.
    }
}