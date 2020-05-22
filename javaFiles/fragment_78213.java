public Game() {

        frame = new JFrame(NAME);
        frame.setSize(400, 400);
        frame.setVisible(true);
        // Sets the size of the window and makes it visible.
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);
        // Sets preferred size and layout to null.
        //can = new Canvas();
        //can.setBounds(0, 0, 400, 400);
        //can.setIgnoreRepaint(true);
        setBounds(0, 0, 400, 400);
        setIgnoreRepaint(true);
        // Creates new canvas.
        panel.add(this);
        // Adds the canvas to the JPanel.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        // Makes the window packed, nonresizable, and close the program on exit.
        //can.createBufferStrategy(3);
        createBufferStrategy(3);
        bs = getBufferStrategy();
        // Creates buffer strategy for the canvas.
        System.out.println("Window created.");
        addKeyListener(this);
    }