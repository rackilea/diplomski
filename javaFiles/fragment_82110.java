private Action buscador() {
    return new Action() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            JFileChooser find = new JFileChooser();

            int result = find.showOpenDialog(espacio);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = find.getSelectedFile();
                try {
                    document.setPage(file.toURI().toURL());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        @Override
        public void addPropertyChangeListener(
                PropertyChangeListener listener) {
            // TODO Auto-generated method stub

        }

        @Override
        public Object getValue(String key) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean isEnabled() {
            // TODO Auto-generated method stub
            return true;
        }

        @Override
        public void putValue(String key, Object value) {
            // TODO Auto-generated method stub

        }

        @Override
        public void removePropertyChangeListener(
                PropertyChangeListener listener) {
            // TODO Auto-generated method stub

        }

        @Override
        public void setEnabled(boolean b) {
            // TODO Auto-generated method stub

        }

    };
}