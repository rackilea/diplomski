int xCoord = Integer.parseInt(
        JOptionPane.showInputDialog("Enter an X cord."));

JFrame gd = new JFrame();
gd.setLocationRelativeTo(null);
gd.setSize(300, 300);
gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
gd.setVisible(true);

gd.add(new NewPanel());