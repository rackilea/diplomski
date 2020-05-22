int selectedPlayerIndex = -1;

void changePlayerView(int playerIndex) {
    if (selectedPlayerIndex != -1) {
        jlNombresArray.get(selectedPlayerIndex).setBorder(
            BorderFactory.createLineBorder(new Color(240, 240, 240), 1));
    }
    selectedPlayerIndex = playerIndex;
    if (selectedPlayerIndex != -1) {
        jlNombresArray.get(selectedPlayerIndex).setBorder(
            BorderFactory.createLineBorder(new Color(240, 240, 240), 3));
    }
    ... repaint ...
}