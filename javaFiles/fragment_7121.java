public MainPane() {
        myMenuBar = new JMenuBar();

        //notice no call to setJMenuBar

        myFileMenu = new JMenu("File");
        myRegisterItem = new JMenuItem("Register");
        myMenuBar.add(myFileMenu);

        ...
     }