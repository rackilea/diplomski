public static YourPanel extends Panel {
    private static YourPanel instance=null;

    public static YourPanel getInstance() {
        if(instance==null) {
            instance=new YourPanel();
        }
        return instance;
    }
}