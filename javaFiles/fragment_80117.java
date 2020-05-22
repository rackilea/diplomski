public class OpenFile {

private JFrame frame;

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
    public void run() {
        try {
            OpenFile window = new OpenFile();
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});
}

public OpenFile() {
initialize();
}

private void initialize() {
frame = new JFrame();
frame.setBounds(100, 100, 450, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

JTextArea jTextArea1 = new JTextArea();
jTextArea1.setText("Here is a text ... ");
jTextArea1.setBounds(10, 39, 402, 199);

frame.getContentPane().add(jTextArea1);

JScrollPane scrollBar = new JScrollPane(jTextArea1);
scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
scrollBar.setHorizontalScrollBarPolicy(
    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
frame.getContentPane().add(scrollBar);
scrollBar.setBounds(13, 39, 413, 214);

JButton btnNewButton = new JButton("Read the text");
btnNewButton.setBounds(149, 10, 130, 21);
frame.getContentPane().add(btnNewButton);

btnNewButton.addActionListener(new ActionListener () {
    public void actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String nameFile = f.getAbsolutePath();

        try {

            FileReader reader = new FileReader(nameFile);
            BufferedReader br = new BufferedReader(reader);
            jTextArea1.read(br, null);
            br.close();
            jTextArea1.requestFocus();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }


    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // TODO Auto-generated method stub

    }
});
  }
}