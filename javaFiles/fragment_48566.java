public class MyMenuBar extends MenuBar {

    ResourceReference rr;

    public MyMenuBar() {
        Resource pdf = new FileResource(new File("C:/temp/temp.pdf"));
        setResource("help", pdf);
        rr = ResourceReference.create(pdf, this, "help");
    }

    private void openHelp() {
        Page.getCurrent().open(rr.getURL(), "blank_");
    }

    ...
}