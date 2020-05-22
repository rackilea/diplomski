tree.addTreeSelectionListener(new TreeSelectionListener() {
        public void valueChanged(TreeSelectionEvent e) {
            File node = (File) e.getPath().getLastPathComponent();
            System.out.println("You selected " + node);
        }
    });