setLayout(new BorderLayout());

    //now add 3 panel as containers for top, center and bottom content
    JPanel top = new JPanel();
    add(top, BorderLayout.NORTH);
    JPanel center = new JPanel();
    add(center, BorderLayout.CENTER);
    JPanel bottom = new JPanel();
    add(bottom, BorderLayout.SOUTH);

    //manage layout and add content to top container
    top.setLayout(new FlowLayout());//actually it the default
    top.add(new JLabel("Class Name:"));
    JTextField className = new JTextField(10);
    top.add(className);
    top.add(new JLabel("Super Class Name:"));
    JTextField superName = new JTextField(10);
    top.add(superName);

    //todo manage layout and add content to center container
    //todo manage layout and add content to bottom container