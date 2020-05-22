public void setJTextPaneFont(JTextPane jtp, Color c, int from, int to) {
            // Start with the current input attributes for the JTextPane. This
            // should ensure that we do not wipe out any existing attributes
            // (such as alignment or other paragraph attributes) currently
            // set on the text area.

            StyleContext sc = StyleContext.getDefaultStyleContext();

          // MutableAttributeSet attrs = jtp.getInputAttributes();

            AttributeSet attrs = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
            // Set the font color
            //StyleConstants.setForeground(attrs, c);

            // Retrieve the pane's document object
            StyledDocument doc = jtp.getStyledDocument();
            // System.out.println(doc.getLength());

            // Replace the style for the entire document. We exceed the length
            // of the document by 1 so that text entered at the end of the
            // document uses the attributes.
            doc.setCharacterAttributes(from, to, attrs, true);
        }