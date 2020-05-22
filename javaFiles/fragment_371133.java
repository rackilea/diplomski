protected String paramString() {
    String preferredSizeString = (isPreferredSizeSet() ?
                  getPreferredSize().toString() : "");
    String minimumSizeString = (isMinimumSizeSet() ?
                getMinimumSize().toString() : "");
    String maximumSizeString = (isMaximumSizeSet() ?
                getMaximumSize().toString() : "");
    String borderString = (border != null ?
               border.toString() : "");

    return super.paramString() +
    ",alignmentX=" + alignmentX +
    ",alignmentY=" + alignmentY +
    ",border=" + borderString +
",flags=" + flags +             // should beef this up a bit
    ",maximumSize=" + maximumSizeString +
    ",minimumSize=" + minimumSizeString +
    ",preferredSize=" + preferredSizeString;
}