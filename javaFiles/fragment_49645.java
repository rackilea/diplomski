//Frame method
    private void frame() {

        //Tab-panel
        JTabbedPane tabbedPane = new JTabbedPane();

        //Tabs
        tabbedPane.addTab("Login", new LoginTab(window));
        tabbedPane.addTab("MySQL Verbindung", new MySQLConnectionTab()); //TODO Strings einfügen
        //Add tab-panel to frame
        window.add(tabbedPane, BorderLayout.CENTER);
        //window.setSize(400,250);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }