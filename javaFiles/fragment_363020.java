// DON'T DO THIS!
Object source = e.getSource();
Component button = (Component)source;
Component parent = button.getParent();
if (parent == somePanel) doThis();
if (parent == someOtherPanel) doThat();