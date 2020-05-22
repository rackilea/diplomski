F1()
{
    JPanel form = new JPanel();
    form.add(new JLabel("Startnr "+ getStartnr()));
    form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

    JPanel r1 = new JPanel();
    r1.add(new JLabel ("Namn:"));
    r1.add(nfield);
    form.add(r1);
    nfield.addActionListener(this);

    JPanel r2 = new JPanel();
    r2.add(new JLabel ("Land:"));
    r2.add(cfield);
    form.add(r2);
    cfield.addActionListener(this);

    JPanel r3 = new JPanel();
    r3.add(new JLabel ("Ålder:"));
    r3.add(afield);
    form.add(r3);
    afield.addActionListener(this);

    int choice = JOptionPane.showConfirmDialog(null, form, "Ny Tävlande"
                                       , JOptionPane.OK_CANCEL_OPTION);
    // If the value of the user is OK, then do this, else do nothing.                             
    if (choice == JOptionPane.OK_OPTION)
    {
        String name = nfield.getText();
        String country = cfield.getText();
        int age = Integer.parseInt(afield.getText());
        int startnr = getStartnr();

        list.add(new Deltagare(name, country, age, startnr));
    }
    else if (choice == JOptionPane.CANCEL_OPTION)
    {
        System.out.println("CANCEL OPTION SELECTED, DO SOMETHING NOW :-)");
    }
}