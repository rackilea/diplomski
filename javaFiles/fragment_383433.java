JPanel panelMM = new JPanel(new GridLayout(5, 10, 1, 0));    
JButton MM1 = new JButton("BallBounce");
panelMM.add(MM1);
final JFrame frameMM = new JFrame("Game/Main Menu");
frameMM.add(panelMM);
frameMM.setSize(1000,1000);
frameMM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

letsStart.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("panel 2 main menu intro 
                frameMM.setVisible(true);
                frame1.setVisible(false);
            }
        });