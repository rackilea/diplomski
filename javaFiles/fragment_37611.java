ArrayList<String> arrayObject= new ArrayList<String>();
JButton button = new JButton();
JtextField textBox = new JtextField ();

button.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        //inside your action listener:
        String add_item_to_array = textBox.getText().trim();
        arrayObject.add(add_item_to_array);             
    }
});