JButton btnSearch = new JButton("Search");
btnSearch.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) {
        String fileName = textField.getText();
        StringBuilder result = new StringBuilder();
        List <String> searchResult = new Search().cautaFisiere("C:\\AdwCleaner", fileName);

        for (int x = 0; x < searchResult.size(); x++) {
            result.append(searchResult.get(x)).append("<br>");
        }
        lblNewLabel.setText("<html>" + result.toString() + "</html>");
    }
});