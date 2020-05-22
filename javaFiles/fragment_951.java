Button b = new Button(name);
    b.addClickHandler(handler);

    b.setShowHover(false);
    b.setShowRollOver(false);

    String css = "nt-multibutton-button";
    b.setStylePrimaryName(css);
    b.setBaseStyle(css);
    b.setStyleName(css);

    b.setAlign(Alignment.LEFT);

    content.add(b);