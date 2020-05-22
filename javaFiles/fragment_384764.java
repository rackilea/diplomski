public class Test extends JFrame implements ActionListener{
    final JFileChooser fc = new JFileChooser();

    public void saveTextToFile(String text) {

        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));
        fileChooser.setApproveButtonText("Save");
        int actionDialog = fileChooser.showOpenDialog(this);
        if (actionDialog != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File file = fileChooser.getSelectedFile();
        if (!file.getName().endsWith(".txt")) {
            file = new File(file.getAbsolutePath() + ".txt");
        }

        try {
            BufferedWriter outFile = new BufferedWriter(new FileWriter(file));
            outFile.write(text);
            outFile.flush();
            outFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        String text = JOptionPane
                .showInputDialog(null,
                        "Do you want to enter some random text and save it?");
        if (text != null) {
            saveTextToFile(text);
        }
    }
    private void createAndShowGui() {
        Test frame = new Test();
        JButton saveBtn = new JButton("Save Text Example");
        saveBtn.addActionListener(this);
        frame.add(saveBtn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test().createAndShowGui();
            }
        });
    }
}