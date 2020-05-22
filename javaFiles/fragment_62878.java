public class MyPanel extends Panel {

    public MyPanel(String id) {
        ...
        ApplicationContext appCtx = ((MyApplication) getApplication()).getAppCtx();
        ...
    } 
}