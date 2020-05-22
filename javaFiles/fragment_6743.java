public MainView()
{
    janela = new JFrame("Exercicio 15/09");
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel = new JPanel() {
       @Override
       public void paintComponent(Graphics g) {
          super.paintComponent(g);
           g.setColor(Color.BLACK);                   
           g.drawLine(0,0,300,300);
       }
    };
    this.showView();
}


public void showView() {
    janela.pack();
    janela.setSize(750, 600);
    janela.setLayout(null);
    janela.add(panel);
    panel.setBounds(0, 0, 710, 600);
    panel.setVisible(true);

    janela.repaint();
}