button.addActionListener(new ActionListener() {
    public void actionPreformed(ActionEvent arg0) {
          System.out.println("Hello");
          new Timer(1000, new ActionListener() {
            @Override void actionPerformed(ActionEvent e) {
              System.out.println("Goodbye");
            }
          }).start();
     }
};