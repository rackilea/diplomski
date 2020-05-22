button.addSelectionListener(new SelectionListener() {
        public void widgetDefaultSelected(SelectionEvent e) {
        }
        public void widgetSelected(SelectionEvent e) {
            button.setImage(button.getSelection() ? pushedIcon : icon);
            ...
        }           
    });