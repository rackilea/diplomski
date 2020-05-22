class B2 extends JPanel {
   private JButton button = new JButton("Press ME");
   private A a;  // field to hold a reference to A object

   public B2(final A a) {  // constructor parameter to get A refrence
      this.a = a;    // assign reference
      setBorder(BorderFactory.createTitledBorder("B2"));
      add(button);      
      button.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            a.setText("Hello from B2!");  // now can use the reference in program
         }
      });
   }
}