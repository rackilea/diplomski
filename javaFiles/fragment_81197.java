btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

        String input="INSERT INTO kullanicilar (TC,name,surname) VALUES(?,?,?)";
            try {


                PreparedStatement ps=con.prepareStatement(input);

                ps.setInt(1, Integer.parseInt(textField.getText()));
                ps.setString(2, textField_1.getText());
                ps.setString(3, textField_2.getText());


                //ps.execute();
                if(ps.executeUpdate()>0) {
                    JOptionPane.showMessageDialog(null, "user added","user add",JOptionPane.OK_CANCEL_OPTION);
                }


            }catch(SQLException f) {
                f.printStackTrace();
            }

            finally {System.out.println("pressed");}

                frame.setVisible(false);
                new GirisEkrani().setVisible(true);

                }
    });