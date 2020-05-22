@Override
    protected void initComponent() {

        super.initComponent();

        if(!tableCreated) {
            createSimCardsTable();
            tableCreated = true;
        }

        mainWindow = this.getWindow();
        Panel basePanel = new Panel("");

        basePanel.addComponent(inventoryFilterPanel);
        AbstractComponent separatorLine = Cf.horizontalLine(); //Of no signficance
        separatorLine.addStyleName("m2m-horizontal-line-list-separator");
        separatorLine.setWidth("99%");
        basePanel.addComponent(separatorLine);
        basePanel.addComponent(simCardTable);
        basePanel.setSizeFull();
        basePanel.getContent().setSizeUndefined(); // <-- This is the important part

        addComponent(basePanel);
        setExpandRatio(basePanel, 1);

    }