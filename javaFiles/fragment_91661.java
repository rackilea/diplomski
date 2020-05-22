.combo-box > .arrow-button {
    -fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;
    -fx-background-insets: 0 0 -1 0, 0, 1, 2;
    -fx-background-radius: 3px, 3px, 2px, 1px;
    -fx-padding: 0.333333em 0.666667em 0.333333em 0.666667em; /* 4 8 4 8 */
    -fx-text-fill: -fx-text-base-color;
    -fx-alignment: CENTER;
    -fx-content-display: LEFT;
}

.combo-box  > .arrow-button{
    -fx-background-color: -fx-outer-border, -fx-inner-border, -fx-body-color;
    -fx-background-insets: 1 1 1 0, 1, 2;
    -fx-background-radius: 0 3 3 0, 0 2 2 0, 0 1 1 0;
}
.combo-box > .list-cell {
    -fx-background-color:
    linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),
    linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background);
    -fx-background-insets: 1 0 1 1;
    -fx-background-radius: 2 0 0 2;
}
.combo-box:contains-focus {
    -fx-background-color: -fx-focus-color;
    -fx-background-insets: -0.2;
    -fx-background-radius: 3;
}
.combo-box:focused > .list-cell{
    -fx-background-color:
    -fx-control-inner-background,
    -fx-faint-focus-color,
    linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background);
    -fx-background-insets: 1 0 1 1, 1 0 1 1, 3 2 3 3;
    -fx-background-radius: 2 0 0 2, 1 0 0 1, 0;
}

.combo-box :contains-focus > .arrow-button{
    -fx-background-color: -fx-inner-border, -fx-body-color, -fx-faint-focus-color, -fx-body-color;
    -fx-background-insets: 1, 2, 1, 2.6;
    -fx-background-radius: 0 2 2 0, 0 1 1 0, 0 1 1 0, 0 1 1 0;
}