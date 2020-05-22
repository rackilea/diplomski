public class IFrame extends JInternalFrame {

    public IFrame() {
        addInternalFrameListener(new InternalFrameAdapter(){
            public void internalFrameClosing(InternalFrameEvent e) {
                // do something  
            }
        });
    } 
}