private void initViews() {
        cl = new CardLayout(); 
        viewPanel.setLayout(cl);

        cs = new CustomerSearch();
        viewPanel.add(cs, BUTTONPANEL);
    }