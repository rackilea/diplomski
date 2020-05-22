Action add = new Action("Add Values") {
    @Override
    public void run() {
        Bike bike = new Bike();
         bike.setName("BMW");
        tableViewer.refresh();

        tableViewer.setSelection(new StructuredSelection(bike));
    }
};