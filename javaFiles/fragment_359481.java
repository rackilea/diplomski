field = new JTextArea();    
   Button = new JButton();
        Button.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    new Thread() {public void run() {
                       for (int i = Integer.parseInt(field.getText()); i >= 0; i--)
                       {
                           try
                           {
                               Thread.sleep(1000);
                           }
                           field.setText(Integer.toString(i));
                       }
                    }}.start();
                }
            }
        );