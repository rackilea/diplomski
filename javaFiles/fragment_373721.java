list.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            GenericListCellRenderer gn = (GenericListCellRenderer)list.getRenderer();
            Component lastCmp = gn.extractLastClickedComponent();
            if(lastCmp != null) {
               Dialog.show("hello", "Clicked: " + lastCmp.getName(), "OK", null);
            } else {
               Dialog.show("hello", "test", "OK", null);
            }
        }
    });