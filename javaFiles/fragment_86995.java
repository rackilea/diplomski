// Set initial values:
    fromCombo.setSelectedItem(CurrencyConstant.USD);
    toCombo.setSelectedItem(CurrencyConstant.EUR);

    fromCombo.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            toCombo.setSelectedItem(
                // Is EUR in fromCombo selected? Then set USD in toCombo. Else set EUR in toCombo.
                (fromCombo.getSelectedItem() == CurrencyConstant.EUR) ? CurrencyConstant.USD : CurrencyConstant.EUR

            );
        }
    });

    toCombo.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            fromCombo.setSelectedItem(
                // Is EUR in toCombo selected? Then set USD in fromCombo. Else set EUR in fromCombo.
                (toCombo.getSelectedItem() == CurrencyConstant.EUR) ? CurrencyConstant.USD : CurrencyConstant.EUR

            );
        }
    });