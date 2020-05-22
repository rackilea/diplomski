tabbedPane.setUI(new SynthTabbedPaneUI(){

Insets insets =new Insets(0, 0, 0, 0);

@Override
protected Insets getTabInsets(int tabPlacement,
                  int tabIndex){
                  return insets;
}

});