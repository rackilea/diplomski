public class Save {
  private javax.swing.JTextField refernce;
  public Save(javax.swing.JTextField refernce){
    this.refernce=refernce;
  } 
  ...
  //and use JTextField in your methods
  void testMethod() {
    if(refernce!=null){
     String refernceText = refernce.getText();
     .....
    }
  }
}