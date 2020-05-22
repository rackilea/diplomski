static class GameOfLife {

    final int w;
    final int h;
    State[][] frame;

    enum State {

        Dead, Alive;
    }

    public GameOfLife(int w, int h) {
        this.w = w;
        this.h = h;
        frame = new State[h][w];
    }

    public void alive(int x, int y) {
        frame[y][x] = State.Alive;
    }

    public void tick() {
        frame = nextGeneration();
    }

    private int surroundingPopulation(int x, int y) {
        int pop = 0;
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                // On frame - vertically.
                if ((i >= 0 && i < h)
                        // On frame horizontally.
                        && (j >= 0 && j < w)
                        // Alive
                        && (frame[i][j] == State.Alive)
                        // Not the center.
                        && (i != y || j != x)) {
                    pop += 1;
                }
            }

        }
        return pop;
    }

    private State[][] nextGeneration() {
        State[][] next = new State[h][w];
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int pop = surroundingPopulation(x, y);
                // Any live cell
                if (frame[y][x] == State.Alive) {
                    if (pop < 2) {
                        // ... with fewer than two live neighbours dies, as if caused by under-population.
                        next[y][x] = State.Dead;
                    } else if (pop > 3) {
                        // ... with more than three live neighbours dies, as if by overcrowding.
                        next[y][x] = State.Dead;
                    } else {
                        // ... with two or three live neighbours lives on to the next generation.
                        next[y][x] = State.Alive;
                    }
                } else {
                    // Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
                    if (pop == 3) {
                        next[y][x] = State.Alive;
                    }
                }
            }
        }
        return next;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (State[] row : frame) {
            for (State c : row) {
                s.append(c == State.Alive ? "X" : " ");
            }
            s.append("\r\n");
        }
        return s.toString();
    }
}

public void test() {
    GameOfLife g = new GameOfLife(6, 6);
    g.alive(1, 0);
    g.alive(2, 1);
    g.alive(3, 1);
    g.alive(1, 2);
    g.alive(2, 2);
    System.out.println("Before:\r\n" + g);
    g.tick();
    System.out.println("After:\r\n" + g);
}