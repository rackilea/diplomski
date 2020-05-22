private static String mand = "mandatory.";
private static JTextArea test = new JTextArea(mand);

public static String getMand() {
return mand;
}

public static JTextArea getTest() {
return test;
}

public static void setMand(String mand2) {
mand = mand2;
}

public static void setTest(JTextArea test2) {
test = test2;
}

getTest().addKeyListener(new KeyListener() {
    @Override
    public void keyPressed(KeyEvent arg0) {
        // do nothing
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // do nothing
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        if(getTest().getText().startsWith(getMand())) {
            System.out.println("good, text still present");
            setMand(test.getText());
        } else {
            getTest().setText(getMand());
        }
    }

});