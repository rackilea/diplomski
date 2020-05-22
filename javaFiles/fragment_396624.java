combo.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
            System.out.print("Selected Value-");
            System.out.print(combo.getItem(combo.getSelectionIndex()));
        }
    });