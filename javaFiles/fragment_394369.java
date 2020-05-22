boolean login = false;
while(read.nextLine() !=null){
   String user = read.next();
   String pass = read.next();
   read.next();
   if(usernameT.getText().equals(user) && passwordT.getText().equals(pass) && admin.isSelected()){
      login = true;
      break;                 
   }
}
if(login)
   new Menu();
else {
   JOptionPane.showMessageDialog(null, "Incorrect username or password");
   usernameT.setText("");
   passwordT.setText("");
}