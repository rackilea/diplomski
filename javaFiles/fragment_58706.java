// This goes into your initialisation method
String regions[] = {"r1", "r2", "r5", "r10", "etc etc etc"}
Raindrop raindrops[] = new Raindrop[15];
for ( int i = 0; i < raindrops.length; i++ )
{
    raindrop[i] = new Raindrop();
    raindrop[i].coordinate.x = MathUtils.random(screenWidth);
    raindrop[i].coordinate.y = MathUtils.random(screenHeight);
    raindrop[i].sprite = atlas.findRegion(regions[(int)MathUtils.random(regions.length)]);
}