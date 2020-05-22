public void addStudentAction() {
  AddStudent myAddStudentDialog = new AddStudent(this, true, this.management);
  myAddStudentDialog.setVisible(true);
  // now you enter a password on the dialog
  if (this.management.getStudentsPasswort() == null) {
    // There's a bug in AddStudent class
  } else {
    System.out.println("HipHipHooray");
  }
}