JCheckbox check1 = new JCheckbox( "First" );
JCheckbox check2 = new JCheckbox( "Second" );

int numSelected = 0;
JLabel label = new JLabel("0 items selected");

ItemListener itemListener = new ItemListener() {

    public void itemStateChanged( ItemEvent e ) {

        if ( e.getStateChange() == ItemEvent.SELECTED )
            numSelected++;

        else
            numSelected--;

         label.setText(  numSelected + 
                         ( numSelected == 1 ) " item" ? " items" + " selected" );
            // might not have to explicitly re-call label.setText(..)
    }
}

check1.addItemListener( itemListener );
check2.addItemListener( itemListener );