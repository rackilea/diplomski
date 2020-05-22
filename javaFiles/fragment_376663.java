MemButton extends JButton {
    private int[] position = new int(2);

    getPosition(int index) {
        if (index >= position.length || index < 0) {
            return null;
        } else {
            return position[index];
        }
    }

    setPosition(int index, int value) {
        if (index >= position.length || index < 0) {
        } else {
            position[index] = value;
        }
    }

}