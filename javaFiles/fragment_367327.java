import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MVCDemo {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        new Controller(view, model);
    }
}

/*Model contains the information for the view and information from the view
 * as well as the logic.
 * The model is independent of the user interface.
 */
class Model {

    private String fileName;

    String getFileName() {
        return fileName;
    }

    void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

/*View only contains the user interface part*/
class View {

    private Model model;
    private JFrame frame;
    private JButton selectFileButton;
    private JTextField textField;

    void createAndShowGui(Model model){

        this.model = model;

        frame = new JFrame("MVC Model Demo");
        textField = new JTextField(25);
        //do not use null layout
        frame.add(textField, BorderLayout.NORTH); //JFrame uses BorderLayout by default
        selectFileButton = new JButton("Select File");
        frame.add(selectFileButton, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    //may return null
    File getFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
        // pop up  file chooser dialog
        fileChooser.showOpenDialog(frame);
        return fileChooser.getSelectedFile();
    }

    void update() {
        textField.setText(model.getFileName());
    }

    JButton getSelectFileButton() {
        return selectFileButton;
    }
}

/* The controller controls the view and model.
 * Based on the user action, the Controller calls methods in the View and Model
 * to accomplish the requested action.
 */
class Controller implements ActionListener{

    private final Model model;
    private final View view;

    Controller(View view,Model model) {
        this.model=model;
        this.view=view;
        view.createAndShowGui(model);
        view.getSelectFileButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File file = view.getFile();
        model.setFileName(file == null  ? "No file selected" : file.getName());
        view.update(); //alternatively use have View listen to Model changes 
    }
}