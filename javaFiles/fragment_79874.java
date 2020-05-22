JButton newPersonButton = new JButton("New Person");
newPersonButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {

        final Data data = NewPerson.createPerson(frame);
        if (data != null) {

            createAndAddDataLabel(data);

        }
    }
});