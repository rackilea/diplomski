public class Main extends JFrame {

       private final int width = 320;
       private final int height = 640;

       private JPanel firstPanel;
       private JPanel secondPanel;

       private JButton goOn;
       private JButton goBack;


       public Main() {

           firstPanel = new JPanel();
           firstPanel.setBackground(Color.yellow);
           firstPanel.setOpaque(true);
           firstPanel.setPreferredSize(new Dimension(width, height));
           goOn = new JButton("Go on");
           goOn.setPreferredSize(new Dimension(width/2, height/2));
           firstPanel.add(goOn);

           secondPanel = new JPanel();
           secondPanel.setBackground(Color.green);
           secondPanel.setOpaque(true);
           secondPanel.setPreferredSize(new Dimension(width, height));
           goBack = new JButton("Go back");
           goBack.setPreferredSize(new Dimension(width/2, height/2));
           secondPanel.add(goBack);

           add(firstPanel);
           add(secondPanel);

           showFirstPanel();
           setResizable(false);
           pack();

           setLocationRelativeTo(null);
           setVisible(true);

           addButtonsListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand().equals("Go on"))
                       showSecondPanel();
                    else
                       showFirstPanel();
              }
          });
       }

       public void showFirstPanel() {
               secondPanel.setVisible(false);
               firstPanel.setVisible(true);
        }

        public void showSecondPanel() {
             firstPanel.setVisible(false);
             secondPanel.setVisible(false);
        }

        public void addButtonsListener(ActionListener listener) {
              goOn.addActionListener(listener);
              goBack.addActionListener(listener);
        }

        public static void main (String[] args) {
            new Main();
       }
     }