JDialog jd=new JDialog(loginpage.this,"User Registration");
jd.setModal(true);
jd.setLayout(null); // THIS IS A BAD IDEA //
jd.setLocationRelativeTo(null);
// This is somewhat pointless, you've set relative location, but know overridden it...
// You should also be relying on the layout manager and pack to determine the size...
jd.setBounds(400,300, 479, 329); 
jd.setResizable(false);
setLocationRelativeTo(loginpage.this);

// Add you other components

jd.setVisible(true);