interface Refreshable {
    void refresh();
}

class Card1 extends JPanel implements Refreshable {...}
...

// Changing the selected card panel
cardlayout.show(deckpanel, "card name");
for (component card: deckpanel.getComponents()) {
    ((Refreshable) card).refresh();
}