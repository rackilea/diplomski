private JMenuItem[] menuItems = new JMenuItem[67];
{
    // This code is in an initializer block and will
    // run regardless of which constructor is called.
    for (int i = 0; i < menuItems.length; i++) {
        this.menuItems[i] = new JMenuItem(numberToWords(i + 1));
    }
}

private static String numberToWords(int number) {
    // Code here
}