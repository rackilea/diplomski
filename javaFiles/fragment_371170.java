pricePerLiter.addFocusListener(new java.awt.event.FocusAdapter() {
    public void focusGained(java.awt.event.FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pricePerLiter.selectAll();
            }
        });
    }
});