Character[] buttonsToAdd = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

Map<Character, JButton> buttons = new HashMap<Character, JButton>();
for (Character c : buttonsToAdd) {
    buttons.put(c, new JButton(c.toString()));
}