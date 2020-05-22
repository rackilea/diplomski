public class CustomjobHandler implements JobHandler {

  public static final String TYPE = "customjobHandler";

    public String getType() {
      return TYPE;
    }

    public void execute(String configuration, ExecutionEntity execution, CommandContext commandContext) {
      // provide custom job execution logic
    }    
}