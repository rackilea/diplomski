but1.addActionListener(new ActionListener() 
    {
        @Override
            public void actionPerformed(ActionEvent e) {

                String text = jta.getText();
                File file = new File("D:/sample.txt");  
                FileWriter fw;
                try
                {
                    fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    jta.write(bw);

                }
                catch (Exception e1) 
                {                       
                    e1.printStackTrace();
                }

            }
        });