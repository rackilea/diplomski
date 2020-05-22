// 2 JPanels for example
    JPanel panel1 = new JPanel();
    panel1.setName("pan1");
    getContentPane().add(panel1);
    JPanel panel2 = new JPanel();
    panel2.setName("pan2");
    getContentPane().add(panel2);

    // creating the JSplitPane container with those panels
    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel1, panel2);

    // get all components from the JSplitPane and print their names
    Component[] components=splitPane.getComponents();
    for(Component c:components){
        System.out.println(c.getName());
    }