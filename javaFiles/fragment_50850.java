public DrawArea() {
        A = new Point(100, 200);
        B = new Point(200, 300);
        button = new JButton("Text");
        button.setBounds(0, 0, 100, 50);

        this.add(button); // add this line
    }