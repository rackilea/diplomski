class MyClass {

    double mon = 0.;  // <- declare it as a field

    void myMethod() {
      finalize.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
                mon = Double.parseDouble(monday.getText());  // <- accessible
           }
      });
      System.out.println(mon);  // <- accessible
    }
}