class AddressBookForm extends JPanel {
    JTextField firstName = new JTextField(20);
    JTextField lastName = new JTextField(20);
    JTextField telephone = new JTextField(20);
    JTextField email = new JTextField(20);

    public AddressBookForm() {
    ...
    }

    private class Person { ... }

    private List<Person> addressList = new ArrayList<Person>();

    private class AddressBookManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            addressList.add(new Person(...));
            System.out.println("Hello, " + firstName.getText());
        }

        public void setName(String name) {
            firstName.setText(name);
        }
    }
}