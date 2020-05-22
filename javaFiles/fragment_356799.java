VirtualComposite result = new VirtualComposite(parent, SWT.NONE);
    result.setModel(new VirtualCompositeModel() {

        @Override
        public int getSize() {
            return 5;
        }

        @Override
        public int getHeightAt(int index) {
            return 500;
        }

        @Override
        public Control createElementAt(Composite p, int index) {
            final Button button = new Button(p, SWT.PUSH);
            button.setText("Button #" + (1 + index)); 
            button.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).hint(-1, BUTTON_HEIGHT).create());
            return button;
        }
    });