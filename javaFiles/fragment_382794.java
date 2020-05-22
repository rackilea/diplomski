AddCataFrame(Catalgogue catalogue)
{
    super("Add New Catalogue");
    this.catalogue = catalogue; // *************

    setLayout(new FlowLayout());

    lname = new JLabel("Name:", SwingConstants.LEFT);

    tname = new JTextField(15);

    textListener t = new textListener();
    tname.addActionListener(t);

    add(lname);
    add(tname);
}