private class ComboListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        String name = (String)fractalChooser.getSelectedItem();

        if (name != null) {
            cardLayout.show(fractalCards, name);
        }

    }
}