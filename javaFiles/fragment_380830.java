public void actionPerformed(ActionEvent ae) {
    Object obj = ae.getSource();

    if (!numCredits.getText().trim().isEmpty()) {
        numCreditsInt = Integer.parseInt(numCredits.getText());
        double rate = 0;
        double fees = 0;
        double books = 0;
        if (obj == online) {
            rate = 177.96;
            fees = 14.35;
            books = 250.0;
            tType.setText("\n \n Tuition type: Online \n \n Cost/Credit: $177.96 \n Fees: $14.35 \n Textbooks: $250.00 \n \n Total Cost: ");
        } else if (obj == standard) {
            rate = 165.08 + 3.20; //?
            fees = 14.35;
            books = 350.0;
            tType.setText("Tuition type: Standard \n Cost/Credit: $165.08 \n Fees: $14.35 \n Parking: $3.20 \n Textbooks: $350.00 \n Total Costs: ");
        } else if (obj == nursing) {
            rate = 189.78 + 3.20; //?
            fees = 14.35;
            books = 600.0;
            tType.setText("Tuition type: Standard \n Cost/Credit: $189.78 \n Fees: $14.35 \n Parking: $3.20 \n Textbooks: $600.00 \n Total Costs: ");
        }

        double total = calculateOnlineTuition(numCreditsInt, rate, fees, books);
        tType.append(NumberFormat.getCurrencyInstance().format(total) + "\n");

    }

    revalidate();
    repaint();
}

public double calculateOnlineTuition(int numCredits, double rate, double fees,
                double textbooks) {
    //calculate online tuition
    //numCredits = Integer.parseInt(inputCredits);
    rate = 177.96;
    fees = 14.35;
    textbooks = 275.00;
    double tuition = numCreditsInt * rate;
    totalOnline = tuition + fees + textbooks;
    return totalOnline;

    //calculate Standard and Nursing rates once Online works
}