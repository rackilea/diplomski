IsWidget child; // Any widget
HorizontalPanel panel = new HorizontalPanel();
FocusPanel clickBox = new FocusPanel();

clickBox.add(child);
panel.add(clickBox);

clickBox.addClickHandler(...);