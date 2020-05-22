.progress-bar {
    -fx-indeterminate-bar-length: 60;
    -fx-indeterminate-bar-escape: true;
    -fx-indeterminate-bar-flip: true;
    -fx-indeterminate-bar-animation-time: 2;
}
.progress-bar > .bar {
    -fx-background-color: linear-gradient(to bottom, derive(-fx-accent, -7%), derive(-fx-accent, 0%), derive(-fx-accent, -3%), derive(-fx-accent, -9%) );
    -fx-background-insets: 3 3 4 3;
    -fx-background-radius: 2;
    -fx-padding: 0.75em;
}
.progress-bar:indeterminate > .bar {
    -fx-background-color: linear-gradient(to left, transparent, -fx-accent);
}
.progress-bar > .track {
      -fx-background-color: 
          -fx-shadow-highlight-color,
          linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),
          linear-gradient(to bottom, 
            derive(-fx-control-inner-background, -7%),
            derive(-fx-control-inner-background, 0%),
            derive(-fx-control-inner-background, -3%),
            derive(-fx-control-inner-background, -9%)
          );
    -fx-background-insets: 0, 0 0 1 0, 1 1 2 1;
    -fx-background-radius: 4, 3, 2; /* 10, 9, 8 */
}