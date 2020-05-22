Level one = new LevelOne();
Level two = new LevelTwo();

Level currentLevel = one;

public void paintComponent(Graphics g) {
    super.paintComponent(g);

    currentLevel.paint(g);
}