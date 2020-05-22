----------------%<----------------------

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void paint(Graphics g) { // <-- Change from Graphics2D to Graphics

 Graphics2D g2 = (Graphics2D) g;
     Dimension d = getSize();
     System.out.println(d);
            int[] yPoints={150,250,250};
            int[] xPoints={200,150,250};

---------------->%----------------------