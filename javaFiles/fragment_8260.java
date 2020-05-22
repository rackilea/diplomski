public static void main (String [] args){
    JTextField text = new JTextField();
    ActionListener textSetter = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
          JButton clicked = (JButton) e.getSource();
          text.setText(clicked.getText());
      }
    };

    JButton btnVan = new JButton("Van");
    btnVan.addActionListener(textSetter);
    JButton btnCar = new JButton("Sports Car");
    btnCar.addActionListener(textSetter);

    JPanel btnPanel = new JPanel();
    btnPanel.add(btnVan);
    btnPanel.add(btnCar);

    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(text, BorderLayout.NORTH);
    mainPanel.add(btnPanel, BorderLayout.SOUTH);

    JFrame frame = new JFrame ("Type of Vehicle");
    frame.add(mainPanel);
    frame.setSize(400,200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}