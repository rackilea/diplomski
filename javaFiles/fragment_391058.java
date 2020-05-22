static final double DT = 1/60.0;
static final int MAX_UPDATES_PER_FRAME = 3; //for preventing spiral of death
private long currentTimeMillis;

public void create() {
    currentTimeMillis = System.currentTimeMillis();
}

public void render() {
    long newTimeMillis = System.currentTimeMillis();
    float frameTimeSeconds = (newTimeMillis - currentTimeMillis) / 1000f;
    currentTimeMillis = newTimeMillis;

    int updateCount = 0;
    while (frameTimeSeconds > 0f && updateCount <= MAX_UPDATES_PER_FRAME) {
        float deltaTimeSeconds = Math.min(frameTimeSeconds, DT);
        update(deltaTimeSeconds);
        frameTimeSeconds -= deltaTimeSeconds;
        ++updateCount;
    }

    draw();
}