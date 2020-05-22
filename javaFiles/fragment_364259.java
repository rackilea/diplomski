private void makeWindow() {
        // JFrame window = new JFrame("Battleships 2.0");
        setTitle("Battleships 2.0");
        JPanel canvas = new JPanel();

        JLabel title = new JLabel("Battleships 2.0");
        // title.setFont(font);

        JTextField userCoordinates = new JTextField(10);

        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        canvas.setLayout(new FlowLayout());

        add(canvas);
        canvas.add(title);
        canvas.add(userCoordinates);
    }