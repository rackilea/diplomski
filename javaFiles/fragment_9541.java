public class Main  {

public static void main(String[] args) {

    // create parent
    JFrame parent = new JFrame("MainFrame");
    parent.setSize(500, 500);

    // center of screen
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    parent.setLocation(dim.width/2-parent.getSize().width/2, dim.height/2-parent.getSize().height/2);
    parent.setVisible(true);

    createDialog(parent);

}

private static void createDialog(JFrame parent) {

    // create dialogs JFX content
    BorderPane layout = new BorderPane();
    layout.setTop(new Button("HELLO"));
    layout.setBottom(new Button("IT'S ME"));
    Scene scene = new Scene(layout);
    JFXPanel dlgContent = new JFXPanel();
    dlgContent.setScene(scene);
    dlgContent.setPreferredSize(new Dimension(200, 200));
    dlgContent.setVisible(true);

    // create dialog and set content
    JDialog dlg = new JDialog(parent, "Dialog", true);
    dlg.setLocationRelativeTo(parent);
    dlg.getContentPane().add(dlgContent);
    dlg.pack();
    dlg.setVisible(true);

}

}