private void createTextAnchorCol() {
    final CustomCell<MyObject> cell = new CustomCell<MyObject>() {

        @Override
        protected void doAction(String value,
                ValueUpdater<String> valueUpdater, MyObject object) {
            Window.alert("Clicked");
            //do whatever required
        }
    };
    Column<MyObject, String> abc = new Column<MyObject, String>(cell) {

        @Override
        public String getValue(MyObject object) {
            cell.setObject(object);
            return null;
        }
    };