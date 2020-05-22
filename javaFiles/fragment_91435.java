public Lab7(File file) {
    final List<Item> items = null; // Make the items final...
    try {
        items = InventoryReader.read(file);
    } catch (ApplicationException e) {
        LOG.error(e.getMessage());
        return;
    }

    EventQueue.invokeLater(new Runnable() {         
        public void run() {
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