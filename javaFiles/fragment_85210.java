public static JTextPane createActionTextPane(String actionText) {
    JTextPane actionTextPane = new JTextPane();
    actionTextPane.setOpaque(false);

    StyledDocument doc = actionTextPane.getStyledDocument();

    Pattern pattern = Pattern.compile("<FIGHTER>|<CLERIC>|<GOLD>");
    Matcher matcher = pattern.matcher(actionText);
    int previousMatch = 0;
    while (matcher.find()) {

        int startIndex = matcher.start();
        int endIndex = matcher.end();
        String group = matcher.group();

        String subText = actionText.substring(previousMatch, startIndex);
        if (!subText.isEmpty()) {
            actionTextPane.replaceSelection(subText);
        } 
        switch (group) {
            case "<FIGHTER>":
                actionTextPane.insertIcon(new ImageIcon("fifight.gif"));
                break;
            case "<CLERIC>":
                actionTextPane.insertIcon(new ImageIcon("mage.gif"));
                break;
            case "<GOLD>":
                actionTextPane.insertIcon(new ImageIcon("Gold.png"));
                break;
        }

        previousMatch = endIndex;

    }
    String subText = actionText.substring(previousMatch);
    if (!subText.isEmpty()) {
        actionTextPane.replaceSelection(subText);
    }

    actionTextPane.setEditable(false);
    return actionTextPane;
}