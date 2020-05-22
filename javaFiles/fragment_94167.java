public void displayTabWindsAloft() {
    CardLayout card = (CardLayout) viewMainFrame.getPanelContext().getLayout();
    card.show(viewMainFrame.getPanelContext(), "cardWindsAloft");

    viewMainFrame.addButtonsFlightplan();
    viewMainFrame.btnPnlWindsAloft.setEnabled(false);

    viewMainFrame.createPanelWindsAloft();
}