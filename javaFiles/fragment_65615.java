// Net income
net.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent en) {
    String line = "";                     // <=============== It's a local
        double grossENt = Double.parseDouble(gross.getText());

        netin = grossENt -((totalTax+ PRSI + uscTotal) - allcredit);

     line = line +" Net income" + netin; // <================ You never do anything with it
    }
});