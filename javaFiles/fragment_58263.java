import javax.swing.SwingUtilities;

public class MvcPha {

    public static void main(String[] args) {

        // run all on the Swing event thread
        SwingUtilities.invokeLater(() -> {
            Model model = new Model();
            View view = new View();
            new Control(model, view);
        });
    }
}