private class ButtonColorScheme {
    final Color paneBackground;
    final Color buttonBackground;
    final Color textBackground;
    final Color textForeground;

    ButtonColorScheme(Color paneBackground, Color buttonBackground, Color textBackground, Color textForeground) {
        this.paneBackground = paneBackground;
        this.buttonBackground = buttonBackground;
        this.textBackground = textBackground;
        this.textForeground = textForeground;
    }

    void apply() {
        getContentPane().setBackground(paneBackground);
        btnConvert.setBackground(buttonBackground);
        btnReset.setBackground(buttonBackground);
        btnClose.setBackground(buttonBackground);
        btnInfo.setBackground(buttonBackground);
        txtIncome.setBackground(textBackground);
        txtPayable.setBackground(textBackground);
        txtStatus.setBackground(textBackground);
        txtIncome.setForeground(textForeground);
        txtPayable.setForeground(textForeground);
        txtStatus.setForeground(textForeground);
    }
}

private final ButtonColorScheme greenAndGrey = new ButtonColorScheme(
    new Color(127,191,95), new Color(159, 191, 143), new Color(201, 255, 191), new Color(89, 89, 89));     

private final ButtonColorScheme redAndBlack = new ButtonColorScheme(
    new Color(191,120,95), new Color(202, 160, 143), new Color(255, 180, 191), Color.BLACK);

public void btnGreenActionPerformed(ActionEvent evt){
   greenAndGrey.apply();
}

public void btnRedActionPerformed(ActionEvent evt){
   redAndBlack.apply();
}