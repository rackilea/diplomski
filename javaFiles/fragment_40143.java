public class MyClass{

     private JTextField[] textFields;

     public MyClass(){
         initComponents();
         this.textFields = new JTextField[10]  // where 10 is the number of lines in your textfile AND the number of JTextFields you have in your GUI
         // then fill the array (by hand if you like)
         this.textField[0] = koontf;
         this.textField[1] = baamtf;
         // and so on..
     }