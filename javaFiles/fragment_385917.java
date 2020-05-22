JLabel label = new  JLabel("a Label");
    System.out.println(label.getMouseListeners().length); // length is printed as 0

    label.setToolTipText("Danger: setting tool tip will consume mouse event");
    System.out.println(label.getMouseListeners().length); // length is printed as 1

    jTabbedPane1.setTabComponentAt(0, label);

    label.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
           int index =  jTabbedPane1.indexOfTabComponent((Component)e.getSource());
           jTabbedPane1.setSelectedIndex(index);
        }

    });