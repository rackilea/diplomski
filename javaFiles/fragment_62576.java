public void onModuleLoad() {
       final Viewport viewport = new Viewport();
       viewport.setLayout(new FitLayout());

//     final ContentPanel contentPanel = new ContentPanel(new FlowLayout());
//     contentPanel.setHeaderVisible(false);

        final LayoutContainer topContainer = new LayoutContainer(
                new FlowLayout());

        final Button buttonOne = new Button("Top:One");
        topContainer.add(buttonOne);
//    contentPanel.setTopComponent(topContainer);
        final LayoutContainer centerPanel = new LayoutContainer(new FitLayout());

        centerPanel.add(new Button("Center"));
//    contentPanel.add(centerPanel);
        final LayoutContainer botPanel = new LayoutContainer(new FlowLayout());
        botPanel.add(new Button("Bottom"));
//      contentPanel.setBottomComponent(botPanel);

        final ContentPanel panel = new ContentPanel();  
        panel.setHeaderVisible(false);  
        panel.setLayout(new RowLayout(Orientation.VERTICAL));    


        panel.add(topContainer, new RowData(1, -1, new Margins(4)));  
        panel.add(centerPanel, new RowData(1, 1, new Margins(0, 4, 0, 4)));  
        panel.add(botPanel, new RowData(1, -1, new Margins(4)));  

        viewport.add(panel, new FlowData(10));  


        RootPanel.get().add(viewport);

        // Later, add a second button to the topComponent ...
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            @Override
            public void execute() {
                final Button buttonTwo = new Button("Top:Two");
                topContainer.add(buttonTwo); // Doesn't show up at first.
                panel.layout(true);
            }
        });
}