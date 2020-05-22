void addTextFocusSelect(JComponent component){
    if(component instanceof JTextComponent){
        component.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent event) {
                    super.focusGained(event);
                    JTextComponent component = (JTextComponent)event.getComponent();
                    // a trick I found on JavaRanch.com
                    // Without this, some components don't honor selectAll
                    component.setText(component.getText());
                    component.selectAll();
                }
            });

    }
    else
    {
        for(Component child: component.getComponents()){
            if(child instanceof JComponent){
                addTextFocusSelect((JComponent) child);
            }
        }
    }
}