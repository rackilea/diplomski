chkSwing.addItemListener(
  new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
       keyField.setLineWrap( e.getStateChange() == ItemEvent.SELECTED );
    }
  } );