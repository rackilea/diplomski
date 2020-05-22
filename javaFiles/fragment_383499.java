.text-area .content {
    /*the is 1px less top and bottom than TextInput because of scrollpane border */
    -fx-padding: 0.25em 0.583em 0.25em 0.583em; /* 3 7 3 7 */
    -fx-cursor: text;
    -fx-background-color:
        linear-gradient(from 0px 0px to 0px 4px, derive(-fx-control-inner-background, -8%), -fx-control-inner-background);
    -fx-background-radius: 2;
}