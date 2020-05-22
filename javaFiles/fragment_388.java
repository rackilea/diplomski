class Calc implements ActionListener {
    public void actionPerformed(ActionEvent event){
        double base = 0.00;
        double options;
        double total;

        if (Button25.isSelected()){ // changed
            base = base + 999.99;
            String base2 = Double.toString(base);
            lblBaseAns.setText(base2);
        }
        else if (Button32.isSelected()){ // changed
            base = base + 1049.99;
            String base2 = Double.toString(base);
            lblBaseAns.setText(base2);
        }
        else if (Button35.isSelected()){ // changed
            base = base + 1099.99;
            String base2 = Double.toString(base);
            lblBaseAns.setText(base2);
        }
        else if (Button42.isSelected()){ // changed
            base = base + 1155.99;
            String base2 = Double.toString(base);
            lblBaseAns.setText(base2);
        }
    }
}