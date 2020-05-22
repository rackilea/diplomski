.split-menu-button:selected > .label {
    -fx-background-color:
        -fx-shadow-highlight-color,
        linear-gradient(to bottom, derive(-fx-outer-border, -20%), -fx-outer-border),
        linear-gradient(to bottom,
                derive(-fx-color, -22%) 0%,
                derive(-fx-color, -13%) 20%,
                derive(-fx-color, -11%) 50%);
}
.split-menu-button:selected > .arrow-button {
    -fx-background-color:
        -fx-shadow-highlight-color,
        linear-gradient(to bottom, derive(-fx-outer-border, -20%), -fx-outer-border),
        linear-gradient(to bottom,
                derive(-fx-color, -22%) 0%,
                derive(-fx-color, -13%) 20%,
                derive(-fx-color, -11%) 50%);
}
.split-menu-button:selected:focused > .label {
    -fx-background-color:
        -fx-shadow-highlight-color,
        linear-gradient(to bottom,
            derive(-fx-color, -22%) 0%,
            derive(-fx-color, -13%) 20%,
            derive(-fx-color, -11%) 50%),
        -fx-faint-focus-color,
        linear-gradient(to bottom,
            derive(-fx-color, -22%) 0%,
            derive(-fx-color, -13%) 20%,
            derive(-fx-color, -11%) 50%);
}
.split-menu-button:selected:focused > .arrow-button {
    -fx-background-color:
        -fx-shadow-highlight-color,
        linear-gradient(to bottom,
            derive(-fx-color, -22%) 0%,
            derive(-fx-color, -13%) 20%,
            derive(-fx-color, -11%) 50%),
        -fx-faint-focus-color,
        linear-gradient(to bottom,
            derive(-fx-color, -22%) 0%,
            derive(-fx-color, -13%) 20%,
            derive(-fx-color, -11%) 50%);
}