b1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Object[] values = list.getSelectedValues();
        String[] colors = new String[3];
        for (int index = 0; index < Math.min(3, values.length); index++) {
            colors[index] = values[index].toString();
        }
        Customer customer = new Customer(colors[0], colors[1], colors[2]);
    }
});