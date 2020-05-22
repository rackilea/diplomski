new ChangeListener<Object>() {
    @Override
    public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
        if(!(newvalue instanceof Text)) {
            String string = ((String) newvalue).split(" - ")[0];
            System.out.println(string);
        }
    }
}