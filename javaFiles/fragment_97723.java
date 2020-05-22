CardLayout cards = new CardLayout();
    JPanel cardPanel = new JPanel();
    cardPanel.setLayout(cards);

    ACReadContract ACReadContract = new ACReadContract(cards, cardPanel);
    //your external JPanel classes with arguments such as above
    ACMenu ACMenu = new ACMenu(cards, cardPanel);

    cardPanel.add(ACMenu, "Menu");
    cardPanel.add(ACReadContract, "ReadContract");
    //naming and adding them for easy moving between them

    //adding this to frame
    add(cardPanel);