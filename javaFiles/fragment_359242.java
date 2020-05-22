public static void main(String args[]) {
        JFrame frame = new JFrame("Button Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btnExit= new JButton("EXIT");    

        ActionListener actionListenerExitButton = new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Exit Button Was Clicked");
          }
        };
        btnExit.addActionListener(actionListenerExitButton);

        JButton btnEnter = new JButton("ENTER");
        ActionListener actionListenerEnterButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Enter Button Was Clicked");
            }
        };
        btnEnter.addActionListener(actionListenerEnterButton);

        Container contentPane = frame.getContentPane();
        contentPane.add(btnExit, BorderLayout.SOUTH);
        contentPane.add(btnEnter, BorderLayout.NORTH);
        frame.setSize(300, 100);
        frame.setVisible(true);
      }