public class Application implements IApplication {
    public Object start(IApplicationContext content){
        PlatformUI.getWorkbench().getPerspectiveRegistry().setDefaultPerspective("youperspective here");

        //other code...
    }

    //other code...
}