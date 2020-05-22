public class ChooseFile {
    private JFrame frame;
    public ChooseFile() {
        frame = new JFrame();

        frame.setVisible(true);
        BringToFront();
    }
    public File getFile() {
        JFileChooser fc = new JFileChooser();
        if(JFileChooser.APPROVE_OPTION == fc.showOpenDialog(null)){
            frame.setVisible(false);
            return fc.getSelectedFile();
        }else {
            System.out.println("Next time select a file.");
            System.exit(1);
        }
        return null;
    }

    private void BringToFront() {                  
                    frame.setExtendedState(JFrame.ICONIFIED);
            frame.setExtendedState(JFrame.NORMAL);

    }

}