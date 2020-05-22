// Game
private int score;
public int getScore() { return score; }
public void addScore(int delta) { score += delta; }
// Usage
game.addScore(ENEMY_DESTROYED_SCORE);