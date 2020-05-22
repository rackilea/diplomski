ChangeListener ch = new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
            if (e.getSource() instanceof JMenuItem) {
                JMenuItem item = (JMenuItem) e.getSource();
                if (item.isSelected() || item.isArmed()) {
                    System.out.println("Highlighted: " + item.getActionCommand());
                }
            }
        }
    };