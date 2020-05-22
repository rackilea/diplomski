public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ...//all other stuff which was there earlier...e.g. java.awt.EventQueue.invokeLater(new Runnable()...

    }