private static final PseudoClass MY_HOVER = PseudoClass.getPseudoClass("my-hover");

...
buttonReflex1.getStyleClass().setAll("button-reflex");
...

    boolean hovering = ...;
    buttonReflex1.pseudoClassStateChanged(MY_HOVER, hovering);