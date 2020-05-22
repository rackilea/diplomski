class Calc implements ActionListener {
    public void actionPerformed(ActionEvent event){
        double base = 0.00;
        double options;
        double total;

        Object clickedObject = event.getSource();
        if (clickedObject instanceof JRadioButton){
            JRadioButton clickedButton = (JRadioButton)clickedObject;

            if (clickedButton == Button25){
                base = base + 999.99;
                String base2 = Double.toString(base);
                lblBaseAns.setText(base2);
            }
            else if (clickedButton == Button32){
                base = base + 1049.99;
                String base2 = Double.toString(base);
                lblBaseAns.setText(base2);
            }
            else if (clickedButton == Button35){
                base = base + 1099.99;
                String base2 = Double.toString(base);
                lblBaseAns.setText(base2);
            }
            else if (clickedButton == Button42){
                base = base + 1155.99;
                String base2 = Double.toString(base);
                lblBaseAns.setText(base2);
            }
        }
    }
}