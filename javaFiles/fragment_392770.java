private void jButton2ActionPerformed(ActionEvent evt) {
    caselist = new ArrayList<String>();
    for (int i = 0; i < textFields.size(); i++) {
        try {
            double total = calculateTotal(textFields.get(i).getText(), productList.get(i).getPrice());
            caselist.add(productList.get(i).getName() +" Total - £" +  total);
        } catch (NumberFormatException e) {
            caselist.add(productList.get(i).getName() +" invalid amount");
        }
    }
}