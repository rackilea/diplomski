@Service
public class ProcessFileService {

    private FileProcessor fileProcessor;

    public CompilerApiService(String plainText){
        fileProcessor = new FileProcessor(code);
    }

    @Async
    public String getResult(){
       return fileProcessor.getResult();
    }

}