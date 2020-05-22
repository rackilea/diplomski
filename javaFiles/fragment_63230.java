final DataObjectTableModel<File> model = new DataObjectTableModel<File>(header) {
    // Override getValueAt() and getColumnClass() here
};

final JTable table = new JTable(model);
table.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() >= 2 && !e.isPopupTrigger()) {

            int selectedRow = table.rowAtPoint(e.getPoint());

            if (selectedRow != -1) {
                String newName = JOptionPane.showInputDialog (
                        null 
                      , "Please input the new name"
                      , "Rename file"
                      , JOptionPane.INFORMATION_MESSAGE
                );

                if (newName != null) {
                    int modelIndex = table.convertRowIndexToModel(selectedRow);

                    File file = model.getDataObject(modelIndex);

                    // Maybe this part should be done
                    // using a SwingWorker to avoid blocking the EDT
                    String newPath = file.getParent() + File.separator + newName;
                    File newFile = new File(newPath);

                    if (file.renameTo(newFile)) {
                        model.deleteDataObject(modelIndex); // remove the old file
                        model.insertDataObject(newFile, modelIndex); // insert the new file in the same index
                    } else {
                        JOptionPane.showMessageDialog (
                                null
                              , "An error happened trying to rename file " + file.getName()
                              , "Error!"
                              , JOptionPane.WARNING_MESSAGE
                        );
                    }
                }

            } // if (selectedRow != -1)

        } // if (e.getClickCount() >= 2 && !e.isPopupTrigger())

    }
});