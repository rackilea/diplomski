public Test() {
    super("Plankske 1");
    setLayout(new FlowLayout());

    Nummer = new JTextField(10);
    add(Nummer);

    Locatie = new JTextField("980000119818");
    add(Locatie);

    Login = new JTextField(10);
    add(Login);

    Datum = new JTextField(10);
    add(Datum);

    Nummer1 = new JTextField(10);
    add(Nummer1);

    Nummer5 = new JTextField(10);
    add(Nummer5);

    save = new JButton("Save");
    add(save);


    thehandler handler = new thehandler();
    Nummer.addActionListener(handler);
    Locatie.addActionListener(handler);
    Login.addActionListener(handler);
    Datum.addActionListener(handler);
    Nummer1.addActionListener(handler);
    Nummer5.addActionListener(handler);
    save.addActionListener(handler);

    generateCsvFile("c:\\test.csv");

}