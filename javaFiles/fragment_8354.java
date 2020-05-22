JTextPane textPane = new JTextPane();
    try {
        BufferedReader b = new BufferedReader(
                new FileReader("inputfile.txt"));
        String line;
        StyledDocument doc = (StyledDocument) textPane.getDocument();

        while ((line = b.readLine()) != null) {

            if (line.contains("/home/user/pictures")) {
                Style style = doc.addStyle("StyleName", null);
                StyleConstants.setIcon(style, new ImageIcon(line));
                doc.insertString(doc.getLength(), "ignore", style);

            } else {
                Style textStyle = doc.addStyle("StyleName", null);
                //work on textStyle object to get required color/formatting.
                doc.insertString(doc.getLength(), "\n" + line, textStyle);
            }
        }

        b.close();
    } catch (Exception e) {
        e.printStackTrace();
    }