// modified wait method
public WebDriverWait wait_sec(WebDriver driver, int sec) {
    return new WebDriverWait(driver, sec);
}


// display msgbox
public void msg(String string) {
    final JDialog dialog = new JDialog();
    dialog.setAlwaysOnTop(true);    
    JOptionPane.showMessageDialog(dialog, string);
}