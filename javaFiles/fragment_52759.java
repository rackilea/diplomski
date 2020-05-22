<project>
<script language="javascript">
 // imports
 importClass(javax.swing.JPasswordField);
 importClass(javax.swing.JOptionPane);

 var pw = new JPasswordField();
 var choice = JOptionPane.showConfirmDialog(null, pw, "Enter Password..", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

 if (choice == JOptionPane.OK_OPTION) {
  // create ant property
  project.setNewProperty("pwd", pw.getText());
 } else {
  throw "Password required !!";
 }
</script>

<echo>$${pwd} => ${pwd}</echo>
</project>