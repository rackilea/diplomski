public class CreateJobCommand implements Command<String> {

  public String execute(CommandContext commandContext) {

    MessageEntity message = new MessageEntity();
    message.setJobHandlerType(CustomJobHandler.TYPE);
    String config = "some string you want to pass to the hanlder";
    message.setJobHandlerConfiguration(config);

    Context
      .getCommandContext()
      .getJobManager()
      .send(message);

    return message.getId();
  }

}