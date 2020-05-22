// Global field
Array<Vector2> circlePositions = new Array<>();

// initialization method
renderer = new ShapeRenderer();

Random rand = new RandomXS128();
for (int i = 0; i < 200; i++)
{
    circlePositions.add(
            new Vector2(
                    rand.nextInt(Gdx.graphics.getWidth()),
                    rand.nextInt(Gdx.graphics.getHeight())));
    circlePositions.add(
            new Vector2(
                    rand.nextInt(Gdx.graphics.getWidth()),
                    rand.nextInt(Gdx.graphics.getHeight())));
}