public Gui() {
    //variables

    int Gold = 20;
    int Health = 100;
    int MaxHealth = 100;


    //variables end
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    console = new JTextArea();
    console.setBounds(10, 11, 281, 214);
    contentPane.add(console);

    input = new JTextField();
    input.setBounds(10, 236, 281, 20);
    contentPane.add(input);
    input.setColumns(10);

    stats = new JTextArea();
    stats.setBounds(301, 11, 123, 53);
    contentPane.add(stats);

    invintory = new JTextArea();
    invintory.setBounds(301, 75, 128, 137);
    contentPane.add(invintory);

    send = new JButton("Send");
    send.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            String i = input.getText();
            input.setText("");
            stats.setText("");
            stats.append("Health: " + Health + "/" + MaxHealth + "\n");
            stats.append("Gold: " + Gold);
        }
    });
    send.setBounds(301, 224, 128, 32);
    contentPane.add(send);

    stats.append("Health: " + Health + "/" + MaxHealth + "\n");
    stats.append("Gold: " + Gold);

    }