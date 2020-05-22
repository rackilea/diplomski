class Pause extends Screen
{
Vector3 touchPoint;
Pause()
{
 touchPoint = new Vector3();
}
void update(float deltaTime)
{       
if(Gdx.input.justTouched())
    {
        cam.unproject(touchPoint.set(Gdx.input.getX(),Gdx.input.getY(), 0));
        if(OverlapTester.pointInRectangle(Assets.resumeButton.getBoundingRectangle(), touchPoint.x,touchPoint.y))
        {
            some thing u want to do
        }

}