public Lab7(File file) {

    EventQueue.invokeLater(new Runnable() {         
        public void run() {
            // Load the items within the content of the runnable...
            List<Item> items = null;
            try {
                items = InventoryReader.read(file);
            } catch (ApplicationException e) {
                LOG.error(e.getMessage());
                return;
            }
            try {
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                // If Nimbus is not available, use the default.
            }
            try {
                MainFrame frame = new MainFrame(items); // THIS IS WHERE I HAVE TROUBLE
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}