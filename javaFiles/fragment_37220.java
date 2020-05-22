final ActionListener al = new ActionListener() {
    public void actionPerformed(ActionEvent event) {
        try {
            final int intRomeo = Integer.parseInt(romeo.getText());
            final int intSierra = Integer.parseInt(sierra .getText());

            if (intRomeo > 1 && intSierra > 1) {
                // whatever you want to do
                System.exit(0); 
            }
        } catch (/*NumberFormat*/ Exception e) {
            // ...not integers
        }
    };
}
whiskey.addActionListener(al);
yankee.addActionListener(al);