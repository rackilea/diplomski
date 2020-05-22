public CompanySelectionWindow(ArrayList<String> listdata) {
    super("Company Selection Window");
    //model.addElement(element);
    setLayout(new GridBagLayout());
    gbc.insets = new Insets(5, 5, 5, 5);
    label = new JLabel("Choose company:");
    gbc.gridx = 3;
    gbc.gridy = 3;
    add(label);
    jList1.setListData(listdata.toArray());
}