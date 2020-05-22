Louis.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent ce) {
             LouisClub.setEnabled(((JCheckBox)ce.getSource()).isSeleted());
        }
    });