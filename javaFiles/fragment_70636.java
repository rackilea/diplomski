JLabel label = (JLabel) cellComponent; // Or new JLabel();
label.setText(
    "<html>An <span style='background-color: lightskyblue'>example</span> of HTML");

String highlight(String text, String sought) {
     text = StringEscapeUtils.escapeHTML4(text); // <, >
     sought = StringEscapeUtils.escapeHTML4(sought);
     return "<html>" + text.replace(sought, "<b>" + sought + "</b>");
}