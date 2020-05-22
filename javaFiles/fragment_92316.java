public class CommandWithParamsMessage extends
CommandMessage {

    public static CommandWithParamsMessage newMessage() {
        return new CommandWithParamsMessage();
    }

    public CommandWithParamsMessage withParameter(String paramName,
        String paramValue) {
        contents.put(paramName, paramValue);
        return this;
    }

    @Override
    public CommandWithParamsMessage withCommand(String command){
        super.withCommand(command);
        return this;
   }

    @Override
    public CommandWithParamsMessage withID(String s){
        super.withID(s);
        return this;
    }
}