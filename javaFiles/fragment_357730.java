private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();

    // Male/Female radio buttons
    male = new JRadioButton("Male", true); 
    female = new JRadioButton("Female", false);
    add(male);
    add(female);

    buttonGroup = new ButtonGroup();
    buttonGroup.add(male);
    buttonGroup.add(female);


    // Title box MR/Mrs selection
    radioListener radio = new radioListener();  
    male.addActionListener(radio);
    female.addActionListener(radio);    

// Used to set default combo box if there is no user selection
    model.addElement("Mr");
    model.addElement("Master");

    JComboBox nameTitle = new JComboBox(model);

    add(nameTitle);

    public class radioListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        if(male.isSelected()){
            model.removeAllElements();
            model.addElement("Mr");
            model.addElement("Master");
        }

        if(female.isSelected()){
            model.removeAllElements();
            model.addElement("Mrs");
            model.addElement("Miss");
        }
    }