public static final int SUCCESS = 0;
public static final int FAIL = 0;

//...

public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StackOverflow_Image_Resource_Demo window = new StackOverflow_Image_Resource_Demo();
                    // This e
                    window.frmUpdate.setVisible(true);

                    window.setStatus(StackOverflow_Image_Resource_Demo.SUCCESS);
                } catch (Exception e) {
                    e.printStackTrace();
                    Component frame = null;
                    window.setStatus(StackOverflow_Image_Resource_Demo.FAIL);
                    JOptionPane.showMessageDialog(frame, "Update Failed", "Update Failed", JOptionPane.ERROR_MESSAGE);
                    window.dispose();
                }
            }
        });
    }