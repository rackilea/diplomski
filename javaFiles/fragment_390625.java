private Label totalCoinLabel; 

private void drawNoOfCoins() {
    Label.LabelStyle style = new Label.LabelStyle();
    style.font = game.font2;
    totalCoinLabel = new Label(coinScoreController.getTotalCoinString(), style);

   ...    
}