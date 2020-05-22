JButton button = new JButton(" >> JavaProgrammingForums.com <<");
        //Add action listener to button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                a = 5 ;
                System.out.println("You clicked the button");
            }
        });