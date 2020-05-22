Component[] children = jPanel1.getComponents();
// iterate over all subPanels...
for (Component sp : children) {
    if (sp instanceof subPanel) {
        Component[] spChildren = ((subPanel)sp).getComponents();
        // now iterate over all JTextFields...
        for (Component spChild : spChildren) {
            if (spChild instanceof JTextField) {
                String text = ((JTextField)spChild).getText();
                System.out.println(text);
            }
        }
    }
}