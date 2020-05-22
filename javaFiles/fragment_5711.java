@Scope(value = "step")
public class DataItemProcessor implements ItemProcessor<InputData, OutPutData> {

@Value("#{jobParameters['fileName']}")
private String fileName;

  public OutPutData process(final InputData inputData) throws Exception {

        // i want to get job Parameters here ????
      System.out.println("Job parameter:"+fileName);

  }

  public void setFileName(String fileName) {
        this.fileName = fileName;
    }


}