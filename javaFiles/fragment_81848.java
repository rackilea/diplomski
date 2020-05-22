AbstractAction copyAction = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
            for(Component c : container.getComponents()){
                     if(c instanceof JTextField){
                       //add copy paste action
                     }
            }
    }};
 String key = "YOUR KEY COMBINATION HERE";
 KeyStroke keyStroke = KeyStroke.getKeyStroke(key);
 component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
 component.getActionMap().put(key, copyAction);