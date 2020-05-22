import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class fileSumCompute extends JFrame implements ActionListener {

    private JFileChooser fc;
    private JButton copyButton;
    private JButton chooseFileButton;
    private JButton destinationButton;
    private File workingDirectory;
    private JLabel sourceLabel;
    private JLabel destinationLabel;
    private JTextField sourceText;
    private JTextField sourceFileText;
    private JTextField destinationText;
    private File selectedSourceFile = null;
    private File selectedDestinationFolder;
    private static String textToWrite;
    // my first time creating and opening files without direct command line input.

    public fileSumCompute() {
        // peiced together a couple JfileChooser examples and customized... I cant seem
        // to get it to work without the other path selection and preprograming it into
        // the same directory as source file.
        // It works though.
        super("Compute sum of row. New file = \" *_out.txt\" ");
        setLayout(new GridLayout(3, 3, 5, 5));
        fc = new JFileChooser();

        // Open dialog box to make easier to find files
        workingDirectory = new File(System.getProperty("user.dir"));
        fc.setCurrentDirectory(workingDirectory);

        // create labels and buttons
        chooseFileButton = new JButton("CHOOSE SOURCE FILE");
        destinationButton = new JButton("DESTINATION FOLDER");
        copyButton = new JButton("COMPUTE & SAVE FILE"); // copies file so origonal is preserved
        sourceLabel = new JLabel("SOURCE: ");
        sourceText = new JTextField(10);
        sourceText.setEditable(false);
        destinationLabel = new JLabel("DESTINATION: ");
        destinationText = new JTextField(10);
        destinationText.setEditable(false);

        // JFrame tools
        add(sourceLabel);
        add(sourceText);
        add(chooseFileButton);
        add(destinationLabel);
        add(destinationText);
        add(destinationButton);
        add(copyButton);

        // Add this as action listener.
        chooseFileButton.addActionListener(this);
        destinationButton.addActionListener(this);
        copyButton.addActionListener(this);
        // computeF(name);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Object event = arg0.getSource();
        int returnVal;

        if (event == chooseFileButton) {
            returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                selectedSourceFile = fc.getSelectedFile();
                sourceText.setText(selectedSourceFile.getName());
            }
        } else if (event == destinationButton) {
            fc.setCurrentDirectory(new java.io.File("."));
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                selectedDestinationFolder = fc.getSelectedFile();
                destinationText.setText(selectedDestinationFolder.getName());
            }
        } else if (event == copyButton) {
            // where we implement the second file... here is where we'll call to compute the
            // sum of the lines
            String name = selectedSourceFile.getName();
            // changed the output file to read ("Orig name here"_out.txt)
            name = selectedSourceFile.getName().substring(0, name.lastIndexOf(".")) + "_out.txt";
            File destinationFile = new File(selectedDestinationFolder, name);

            try {
                //Files.copy(selectedSourceFile.toPath(), destinationFileFolder.toPath()); // copying and computing
                computeF(selectedSourceFile); // if we can get this to edit the _out.txt file we
                // can do with out creating two seperate files- the previous *_.tmp can just be
                // the *_out.txt
                PrintWriter writer = new PrintWriter(destinationFile, "UTF-8");
                writer.println(textToWrite);
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void computeF(File selectedDestinationFile) throws IOException {
        textToWrite = ""; 
        int sum;
        if (!selectedDestinationFile.isFile()) // IF CANNOT FIND FILE
        {
            System.out.println(selectedDestinationFile.getAbsolutePath() + " - Parameter is not an existing file");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(selectedDestinationFile.getAbsolutePath()))) {
            String line;
            while ((line = br.readLine()) != null) {
                //Split each line, then check value in the array as an int and add to sum.
               String[] temp = line.split(", ");
               sum = 0;

               for (int i = 0; i < temp.length; i++) 
                   sum = Integer.parseInt(temp[i]); 

               textToWrite+= sum + System.getProperty("line.separator");
            }
        }

    }

    public static void main(String[] args) {
        fileSumCompute cpy1 = new fileSumCompute();
        cpy1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cpy1.setSize(600, 150);
        cpy1.setVisible(true);
    }
}