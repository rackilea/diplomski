Color color = new Color();

@Override
public void render() {
    Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    sr.begin();

    Color startColor = Color.YELLOW;
    Color endColor = Color.RED;

    //draw path1
    for (int i = 0; i < 100; ++i) {
        float t = i / 100f;
        //interpolate linearly between start and end colors
        sr.setColor(color
                .set(startColor)
                .lerp(endColor, t)
        );
        // create vectors to store start and end points of this section of the curve
        Vector2 st = new Vector2();
        Vector2 end = new Vector2();
        // get the start point of this curve section
        path1.valueAt(st, t);
        // get the next start point(this point's end)
        path1.valueAt(end, t - 0.01f);
        // draw the curve
        sr.line(st.x, st.y, end.x, end.y);
    }

    sr.end();
}