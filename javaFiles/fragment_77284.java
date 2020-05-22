public class SwingSolution extends JFrame implements ActionListener
{
    private JPanel componentPanel = null;   
    private JPanel mainPanel = null;    
    private JLabel mainLabel = null;    
    private JPanel optionPanel = null;  
    private JPanel accountPanel = null; 
    private JLabel accountLabel = null; 
    private JButton replaceToAccountPanel = null;   
    private JButton replaceToMainPanel = null;

    private final static String MAIN_TO_ACCOUNT = "MainToAccount";
    private final static String ACCOUNT_TO_MAIN = "AccountToMain";

    public JPanel getComponentPanel()
    {
       if(null == componentPanel)
       {
           componentPanel = new JPanel();
           GridBagLayout gridBagLayout = new GridBagLayout();
           componentPanel.setLayout(gridBagLayout);

           GridBagConstraints constraint = new GridBagConstraints();
           constraint.insets = new Insets(10, 10, 10, 10);

           mainPanel = new JPanel();           
           constraint.gridx = 0;
           constraint.gridy = 0;
           mainPanel.setMinimumSize(new Dimension(100, 50));
           mainPanel.setPreferredSize(new Dimension(100, 50));
           mainPanel.setMaximumSize(new Dimension(100, 50));
           mainPanel.setBorder(
                   BorderFactory.createLineBorder(Color.RED));

           mainLabel = new JLabel("Main Panel");
           mainPanel.add(mainLabel);
           componentPanel.add(mainPanel, constraint);

           accountPanel = new JPanel();        
           constraint.gridx = 0;
           constraint.gridy = 0;
           accountPanel.setMinimumSize(new Dimension(100, 50));
           accountPanel.setPreferredSize(new Dimension(100, 50));
           accountPanel.setMaximumSize(new Dimension(100, 50));
           accountPanel.setBorder(
                   BorderFactory.createLineBorder(Color.GREEN));

           accountLabel = new JLabel("Account Panel");
           accountPanel.add(accountLabel);

           componentPanel.add(accountPanel, constraint);

           optionPanel = new JPanel();         
           constraint.gridx = 0;
           constraint.gridy = 1;
           optionPanel.setMinimumSize(new Dimension(100, 50));
           optionPanel.setPreferredSize(new Dimension(100, 50));
           optionPanel.setMaximumSize(new Dimension(100, 50));
           optionPanel.setBorder(
                   BorderFactory.createLineBorder(Color.BLUE));
           componentPanel.add(optionPanel, constraint);

           replaceToAccountPanel = new JButton("Account Button");
           replaceToAccountPanel.setName(MAIN_TO_ACCOUNT);
           constraint.gridx = 0;
           constraint.gridy = 2;
           replaceToAccountPanel.setSize(new Dimension(800, 30));
           replaceToAccountPanel.addActionListener(this);
           componentPanel.add(replaceToAccountPanel, constraint);

           replaceToMainPanel = new JButton("Main Button");
           replaceToMainPanel.setName(ACCOUNT_TO_MAIN);
           constraint.gridx = 1;
           constraint.gridy = 2;
           replaceToMainPanel.setMinimumSize(new Dimension(800, 30));
           replaceToMainPanel.addActionListener(this);
           componentPanel.add(replaceToMainPanel, constraint);
       }       
       return componentPanel;
    }

    public void actionPerformed (ActionEvent evt) 
    {
        JButton buttonClicked = (JButton) evt.getSource();
        if(buttonClicked != null)
        {
            if(buttonClicked.getName().equals(MAIN_TO_ACCOUNT))
            {
                mainPanel.setVisible(false);
                accountPanel.setVisible(true);
            }
            else if(buttonClicked.getName().equals(ACCOUNT_TO_MAIN))
            {
                mainPanel.setVisible(true);
                accountPanel.setVisible(false);
            }
        }       
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        SwingSolution main = new SwingSolution();

        frame.setTitle("Simple example");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        frame.setContentPane(main.getComponentPanel());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}