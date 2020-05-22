public class ExecutorButton extends Button implements EventHandler<MouseEvent> {

    private String myExecutable;

    public ExecutorButton(String pathToExecutable) {
        this.myExecutable = pathToExecutable;
        this.addEventHandler(MouseEvent.MOUSE_CLICKED,this);
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("Executing > "+myExecutable);
        executeMyExecutable();
    }
}