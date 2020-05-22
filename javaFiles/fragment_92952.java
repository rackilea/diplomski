if ( Gdx.input.isKeyPressed(Input.Keys.RIGHT) )
{
    batch.draw(right.getKeyFrame(time, true), 100, 0);
}
else if ( Gdx.input.isKeyPressed(Input.Keys.LEFT) )
{
    batch.draw(left.getKeyFrame(time, true), 100, 0);
}
else
{
    batch.draw(middle.getKeyFrame(time, true), 100, 0);
}