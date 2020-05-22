JComboBox c = new JComboBox ();
c.addItem ("Up");
c.addItem ("Down");
c.addItem ("Strange");
c.addItem ("Charm");
c.addItem ("Top");
c.addItem ("Bottom");
c.addItemListener (this);

/** Get the combobox item events here. **/
public void itemStateChanged (ItemEvent e) {
  String command = e.getItem ().toString ();
  if (command.equals ("Charm") )
    System.out.println(command);;

}