if (tabEvents.getSelectedComponent().equals(tabAddEvent)) {
        JPanel jp = new AddEvent();
    if (initializedAdd == false) {
    tabAddEvent.setLayout(new GridBagLayout());
    tabAddEvent.add(jp);
    initializedAdd = true;
    }
    }