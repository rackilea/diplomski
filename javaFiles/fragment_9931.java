box.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (box.getSelectedIndex() == 0) {
                showJewlryForm();
            } else if (box.getSelectedIndex() == 1) {
                showStockForm();
            } else if (box.getSelectedIndex() == 2) {
                showDeviceForm();
            }

        }
    });    

    private void showJewlryForm() {
        JewelryForm f = new JewelryForm();
        try {
            int svar = JOptionPane.showConfirmDialog(Program.this, f, "Nytt smycke", JOptionPane.OK_CANCEL_OPTION);
            if (svar != JOptionPane.OK_OPTION)
                return;

            String name = f.getName();
            int stones = f.getStones();
            boolean isGold = f.getGold();

            addJewelry(name, stones, isGold);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Program.this, "Fel inmatning!");
        }
    }

    private void showStockForm() {

        StockForm f = new StockForm();
        try {
            int svar = JOptionPane.showConfirmDialog(Program.this, f, "Ny aktie", JOptionPane.OK_CANCEL_OPTION);
            if (svar != JOptionPane.OK_OPTION)
                return;

            String name = f.getName();
            int amount = f.getAmount();
            int stockPrice = f.getStockPrice();

            addStock(name, amount, stockPrice);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Program.this, "Fel inmatning!");
        }

    }

    private void showDeviceForm() {

        DeviceForm f = new DeviceForm();
        try {
            int svar = JOptionPane.showConfirmDialog(Program.this, f, "Ny apparat", JOptionPane.OK_CANCEL_OPTION);
            if (svar != JOptionPane.OK_OPTION)
                return;

            String name = f.getName();
            int purchasePrice = f.getPurchasePrice();
            int wear = f.getWear();

            addDevice(name, purchasePrice, wear);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Program.this, "Fel!");
        }

    }