class AddGui implements ActionListener {

    private JTextField idField = new JTextField(5);
    //Other input fields

    @Override
    public void actionPerformed(ActionEvent e) {
        //Get all other fields here
        Insert record = new Insert(Integer.parseInt(idField.getText()), "name", "sex", "dept", 0);
        //call to insert()
    }