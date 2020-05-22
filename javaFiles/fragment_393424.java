.progress-bar {
    -fx-skin: "com.sun.javafx.scene.control.skin.ProgressBarSkin";
    -fx-background-color:
        -fx-box-border,
        linear-gradient(to bottom, derive(-fx-color,30%) 5%, derive(-fx-color,-17%));
    -fx-background-insets: 0, 1;
    -fx-indeterminate-bar-length: 60;
    -fx-indeterminate-bar-escape: true;
    -fx-indeterminate-bar-flip: true;
    -fx-indeterminate-bar-animation-time: 2;
}

.progress-bar .bar {
    -fx-background-color:
        -fx-box-border,
        linear-gradient(to bottom, derive(-fx-accent,95%), derive(-fx-accent,10%)),
        linear-gradient(to bottom, derive(-fx-accent,38%), -fx-accent);
    -fx-background-insets: 0, 1, 2;
    -fx-padding: 0.416667em; /* 5 */
}

.progress-bar:indeterminate .bar {
    -fx-background-color: linear-gradient(to left, transparent, -fx-accent);
}

.progress-bar .track {
     -fx-background-color:
        -fx-box-border,
        linear-gradient(to bottom, derive(-fx-color,-15%), derive(-fx-color,2.2%) 20%, derive(-fx-color,60%));
    -fx-background-insets:  0, 1;
}

.progress-bar:disabled {
    -fx-opacity: -fx-disabled-opacity;
}