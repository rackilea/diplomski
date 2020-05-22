popup.add(new AbstractAction("Reload") {

    public void actionPerformed(ActionEvent e) {
        System.out.println("Reload");
        try {
            root = getRoot("xml.xml");
            setModel(new XMLTreeModel(root));
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
});