public TestFrame() {
        super("Test Dock");
        rw = new RootWindow(null);
        JMenu mu = new JMenu("File");
        JMenuItem mi = new JMenuItem("Add Dock");
        mi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                View vw = new View("Dock", null, new JLabel("test"));
                DockingUtil.addWindow(vw, rw);
            }
        });
        JMenuBar mb = new JMenuBar();
        mu.add(mi);
        mb.add(mu);
        this.setJMenuBar(mb);
        this.setLayout(new BorderLayout());
        this.add(rw);

    }