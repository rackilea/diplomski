private class buttonEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Create Profile!")) {
          String fn = tf1.getText().trim();
          String ln = tf2.getText().trim();
          String g = tf3.getText().trim();
          String ht = tf4.getText().trim();
          UserProfile u1 = new UserProfile(fn,ln,g,ht);
        }
    }

}