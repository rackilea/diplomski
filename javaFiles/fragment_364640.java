String style = "";
if (board.getValue(i, j) != 0) {
    style += "-fx-background-color: #ebe6e6;";
}

if ((i == 2 || i == 5) && (j == 2 || j == 5)) {
    style += "-fx-border-width: 1 3 3 1;";
} else if (i == 2 || i == 5) {
    style += "-fx-border-width: 1 3 1 1;";
} else if (j == 2 || j == 5) {
    style += "-fx-border-width: 1 3 1 1;";
}
tfs[c].setStyle(style);