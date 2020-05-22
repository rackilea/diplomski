@Override
    public void actionPerformed(ActionEvent e) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            // child component must be a JList, but not jli
            if(component instanceof JList && !component.equals(jli)) {
                JList firstList = (JList) component;
            }
        }
    }