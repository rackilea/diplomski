public MainPanel(){
    list = new ListWidget();
    maintenance = new MaintenanceWidget();
    panel = new SplitLayoutPanel();

    panel.setPixelSize(500, 400);

    panel.addWest(list, 200);
    panel.add(maintenance);     
    initWidget(panel);
}