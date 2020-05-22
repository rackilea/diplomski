class YourClass {

     private JButton[] buttons; // instance variable, accessible to all methods in class 

     public void foo() {
          buttons = new JButton[100]; // can use buttons here
     }

     public void bar() {
          // can also use buttons here
          for (JButton button : buttons) {  

         }
     }
}