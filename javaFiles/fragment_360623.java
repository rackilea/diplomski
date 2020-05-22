Action actionListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JComboBox source = (JComboBox) actionEvent.getSource();
            source.requestFocus();
            source.showPopup();
            // source.setFocusable(true);
        }
    };