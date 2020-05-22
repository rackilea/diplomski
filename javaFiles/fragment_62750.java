public class PreloaderDialog extends JDialog {              

        publicPreloaderDialog() {

                initialize();
        }

        public final void initialize() {

                JLabel waittext = new JLabel("Wait, please");    
                add(waittext);

                setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                setModalityType(ModalityType.APPLICATION_MODAL);

                setTitle("Loading in progress");

                setLocationRelativeTo(null);
                setSize(300, 120);
        }

        public void hide() {

           setVisible(false);                               
        }

        public void show() {                                       

            setVisible(true);                               
        }

}