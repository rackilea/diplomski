submit.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
        try {
             String name = tf1.getText();
             String ID = tf2.getText();
             String email = tf3.getText();
             String address = tf4.getText();
             String fileName = ID + "Details.csv";
             File file = new File(fileName);
             FileWriter fw = new FileWriter(fileName); 
             name = name.concat(",");
             ID = ID.concat(",");
             email = email.concat(",");
             address = address.concat(",");
             fw.write(name);
             fw.write(ID);
             fw.write(email);
             fw.write(address);
             fw.close();
        }
        catch (IOException ex){
             ex .printStackTrace();
             System.exit(0);
        }          
    }
});