@Override
    public void paintComponent(Graphics g) {
        System.out.println("Inside the paintComponent method");
        g.setColor(Color.red); // here
        g.fillRect(0, 0, this.getWidth(), this.getHeight()); //here

        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }

        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        System.out.println(getSize().width);
        System.out.println(getSize().height);
        super.paintComponent(g);
    }