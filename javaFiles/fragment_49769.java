private Text netPrice; // Let's say this holds your net-price text

netPrice.addModifyListener(new ModifyListener() {
    @Override
    public void modifyText(ModifyEvent e) {
        if (netPrice == Display.getCurrent().getFocusControl()) {
            //
            // Do your logic here, it's overflow safe
            //
        }
    }
});