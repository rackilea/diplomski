public static void main(String[] args) {
   MainForm myMainForm = new MainForm();
   // ... whatever code is necessary to set up the 
   // ... MainForm object so it can be visualized
   myMainForm.setVisible(true); // and show it

   Log myLogObject = new Log(myMainForm);
   //...
}