public static final float MAX_DELTA = 1/50f;
public static final int MAX_UPDATES_PER_FRAME = 3;
private float elapsedTime;

public void render (float deltaTime){
    elapsedTime += deltaTime;
    int updates = 0;
    while (elapsedTime > 0 && updates < MAX_UPDATES_PER_FRAME){
        update(Math.min(MAX_DELTA, elapsedTime));
        elapsedTime = Math.max(0, elapsedTime - MAX_DELTA);
        updates++;
    }

    // drawing
}