private List<Button> buttons = new LinkedList<>();

...

    // Not enough buttons, need to add new ones
    if (number > buttons.size()) {
        for(int i = buttons.size(); i < number; i++) {
            Button buttonAdded = new Button("Button " + i);
            buttons.add(buttonAdded);
        }
    }
    // Too many buttons, remove the extras
    else if (buttons.size() > number) {
        List<Button> buttonsToRemove = buttons.subList(number, buttons.size());
        buttonsToRemove.forEach(verticalLayout::remove);
        buttonsToRemove.clear();
    }