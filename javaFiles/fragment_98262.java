private void drawStringMiddleOfPanel(String string, Graphics g) {
            String message2 = string;
            int stringWidth = 0;
            int stringAccent = 0;
            int xCoordinate = 0;
            int yCoordinate = 0;
            // get the FontMetrics for the current font
            FontMetrics fm = g.getFontMetrics();


        /** display new message */
            /** Centering the text */
            // find the center location to display
            stringWidth = fm.stringWidth(message2);
            stringAccent = fm.getAscent();
            // get the position of the leftmost character in the baseline
            xCoordinate = getWidth() / 2 - stringWidth / 2;
            yCoordinate = getHeight() / 2 + stringAccent / 2;

            // draw String
            g.drawString(message2, xCoordinate, yCoordinate);
            currentMessage = message2;  // alternate message
        }