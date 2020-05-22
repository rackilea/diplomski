public class MyAppHandler extends CefAppHandlerAdapter {
    public MyAppHandler(String [] args) {
        super(args);
    }

    @Override
    public void onBeforeCommandLineProcessing(String process_type, CefCommandLine command_line) {
        super.onBeforeCommandLineProcessing(process_type, command_line);
        if (process_type.isEmpty()) {
            command_line.appendSwitchWithValue("persist-session-cookies","true");
        }
    }
}