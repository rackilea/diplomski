public static final float FIXED_TIMESTEP = 1/50f;
public static final int MAX_UPDATES_PER_FRAME = 3;
private float elapsedTime;

public void render (float deltaTime){
    elapsedTime += deltaTime;
    int updates = 0;
    while (elapsedTime >= FIXED_TIMESTEP = && updates < MAX_UPDATES_PER_FRAME){
        update(FIXED_TIMESTEP);
        elapsedTime -= FIXED_TIMESTEP;
        updates++;
    }

    // drawing
}