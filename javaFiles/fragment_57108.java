public class View implements CommonView {
    public View(ViewController viewController) {

    }

    @Override
    public void updateGui(String text) {
        System.out.println("Swing View");
    }
}