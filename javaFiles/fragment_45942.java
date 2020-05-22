Map<Color, JButton> col = new HashMap<Color, JButton>();
for (int index = 0; index < shuffledColors.size(); index++) {
    Color color = shuffledColors.get(index);
    Character c = shuffledCharacters.get(index);

    JButton btn = buttons.get(c);

    col.put(color, btn);
}