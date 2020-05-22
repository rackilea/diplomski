Gdx.gl.glClearColor(0f, 0f, 0f, 1);
Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

renderer.begin(ShapeType.Filled);
for (int i = 0; i < circlePositions.size; i++)
{
    Vector2 pos = circlePositions.get(i);

    if (i % 2 == 0)
    {
        renderer.setColor(Color.DARK_GRAY);
        renderer.circle(pos.x, pos.y, 5);
    } else
    {
        renderer.setColor(Color.GRAY);
        renderer.circle(pos.x, pos.y, 3);
    }
}
renderer.end();