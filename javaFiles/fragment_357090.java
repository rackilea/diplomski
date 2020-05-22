public class BuyTicket {
    //...

    public JPanel createContentPane() throws IOException {
        // ...
        Select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // ...
            }

            // within addActionListener scope
            private void displayDate(Object selected) {
                // ...
            }
        });
        // ...
    }
}