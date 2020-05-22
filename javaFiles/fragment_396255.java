final JLabel label = new JLabel();
label.setText(item.getQuantity().toString());
item.addPropertyChangeListener( new PropertyChangeListener(){
   @Override
   public void propertyChange( PropertyChangeEvent event ){
     if ( "quantity".equals( event.getPropertyName ) ){
        //I assume this happens on the EDT, otherwise use SwingUtilities.invoke*
        label.setText( (String)event.getNewValue() );
     }
   }
});