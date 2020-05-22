class Lab17_4combo extends JFrame implements ActionListener
    {
        Container container;
        JComboBox colors;// you declared colors. 

        public Lab17_4combo()
        {
            super("ComboBox ");
            container = this.getContentPane();
            container.setLayout(new FlowLayout());
            setSize(300,200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            String[] selectColor = {"Red", "Yellow", "Blue", "Green", "Magenta"};

            //JComboBox colors = new JComboBox(selectColor);// You declared colors again. Change     this line to 

            colors = new JComboBox(selectColor);
            colors.setSelectedIndex(-1);
            colors.addActionListener(this);

            container.add(colors);
            setVisible(true);
        }