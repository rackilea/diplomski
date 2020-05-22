public class PetUI extends JFrame implements ActionListener{

    JButton btnAdd = new JButton("Add");
    JButton btnCancel = new JButton("Cancel");
    JTextField txtbox1 = new JTextField();
    JTextField txtbox2 = new JTextField();
    JList<String> list;
    DefaultListModel<String> listModel;
    JComboBox<String> petList;

    public PetUI(){

        super("Pet Shop");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        //inputs
        panel1.setLayout(new GridLayout(3,4));
        add(panel1,BorderLayout.NORTH);
        panel1.add(new JLabel("Pet Type: "));
        String [] animals = {"Cat","Dog","Rabbit"};
        petList = new JComboBox<>(animals);
        panel1.add(petList);
        panel1.add(new JLabel("Breed: "));
        panel1.add(txtbox1);
        panel1.add(new JLabel("Name: "));
        panel1.add(txtbox2);

        //buttons
        add(panel2,BorderLayout.CENTER);
        panel2.add(btnAdd);
        btnAdd.addActionListener(this);
        panel2.add(btnCancel);

        //JList
        listModel = new DefaultListModel<>();

        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel3.add(list);
        add(panel3,BorderLayout.SOUTH);

        setVisible(true);
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){

        StringBuilder sb = new StringBuilder((String)petList.getSelectedItem());
        sb.append(" ")  //add space
          .append(txtbox1.getText())
          .append(" ")
          .append(txtbox2.getText());

        listModel.addElement(sb.toString());
    }
    public static void main(String [] args){
        new PetUI();
    }
}