private final static PseudoClass GREEN = PseudoClass.getPseudoClass("green");
private final static PseudoClass RED = PseudoClass.getPseudoClass("red");

...

boolean isGreen = clickedBtn.getPseudoClassStates().contains(GREEN);
clickedBtn.pseudoClassStateChanged(GREEN, !isGreen);
clickedBtn.pseudoClassStateChanged(RED, isGreen);