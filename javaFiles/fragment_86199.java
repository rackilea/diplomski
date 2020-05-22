list.addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {

            JLabel price = new JLabel(listColorValues[list
                    .getSelectedIndex()] + "");

            con.add(price);
            con.revalidate();
        }
    });