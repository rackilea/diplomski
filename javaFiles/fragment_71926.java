private void initMonthView() {
    _monthView = new JXMonthView();
    //        _monthView.setSelectionModel(new SingleDaySelectionModel());
    _monthView.setTraversable(true);
    _monthView.addPropertyChangeListener(getMonthViewListener());
}