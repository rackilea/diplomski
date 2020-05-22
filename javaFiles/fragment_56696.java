class DisplayPanel extends JPanel
{
    public static final int PLAYERS = 5;
    private JComboBox cmbPlayerNumber;
    private JTextField[] txtPlayerName;
    private JLabel lblPlayerNumber;

    public DisplayPanel(){
        setPreferredSize(new Dimension(170, 240));
        createComponents();
        initComponents();
        loadComponents();
        setBoundsForComponents();       
    }

    private void createComponents(){
        cmbPlayerNumber = new JComboBox(new String[]{"1", "2", "3", "4", "5"});
        txtPlayerName = new JTextField[PLAYERS];
        lblPlayerNumber = new JLabel("Num of Players");     
    }

    private void initComponents(){
        for(int x=0; x<PLAYERS; x++){
            txtPlayerName[x] = new JTextField("No Name " + (x+1));
            txtPlayerName[x].setVisible(false);     
        }
        cmbPlayerNumber.setSelectedIndex(-1);
        cmbPlayerNumber.addActionListener(new CmbListener());       
    }

    private void loadComponents(){
        add(cmbPlayerNumber);
        add(lblPlayerNumber);
        for(int x=0; x<PLAYERS; x++)
            add(txtPlayerName[x]);          
    }

    private void setBoundsForComponents(){
        setLayout(null);
        lblPlayerNumber.setBounds(10, 0, 150, 30);          
        cmbPlayerNumber.setBounds(10, 30, 150, 30);
        for(int x=0; x<PLAYERS; x++)
            txtPlayerName[x].setBounds(10, (30*x)+70, 150, 30);
    }

    private class CmbListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int numOfPlayers = cmbPlayerNumber.getSelectedIndex() + 1;
            for(int x=0; x<numOfPlayers; x++)
                txtPlayerName[x].setVisible(true);
            for(int x=numOfPlayers; x<PLAYERS; x++){
                txtPlayerName[x].setVisible(false);             
                txtPlayerName[x].setText("No name " + (x+1));                   
            }               
        }
    }                   
}