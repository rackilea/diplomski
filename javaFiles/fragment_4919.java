public class AddRoomListener implements ActionListener{
    private InternalFrame iFrame;

    public AddRoomListener(InternalFrame iFrame){
        this.iFrame = iFrame;
    }
    public void actionPerformed(ActionEvent event) { 
        iFrame.getIntFrame2().setVisible(true);
        iFrame.getIntFrame2().toFront();
    }
}