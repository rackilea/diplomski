listBox = new ListBox();
listBox.addItem(" ");
listBox.addItem("A");
listBox.addItem("B");
listBox.addItem("C");
listBox.addChangeHandler(new ChangeHandler() {
        public void onChange(ChangeEvent changeEvent) {
            SelectElement selectElement = listBox.getElement().cast();
            selectElement.getOptions().getItem(0).setDisabled(true);

        }
    });