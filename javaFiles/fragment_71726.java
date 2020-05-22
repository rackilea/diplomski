int landPrice = ((int) (Math.random() * (26 - 17)) + 17);
int purchasedLand =Integer.parseInt(landBox.getText().trim());

while (!inputAccepted) {

    if ((g.getGrain() - (purchasedLand * landPrice)) < 0)
        purchasedLand = Integer.parseInt(JOptionPane.showInputDialog(landBox, 
                    "please re-input the amount of purchased land,"
                  + " we cannot afford the given amount! "));
    else {
        System.out.println("yay");
        inputAccepted = true;
    }
}