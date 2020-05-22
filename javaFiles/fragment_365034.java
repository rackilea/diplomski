public class Ball extends Sprite{

final FixtureDef ballFixtureDef = PhysicsFactory.createFixtureDef(1.0f, 0.0f, 0.0f, false, Main.CATEGORYBIT_BALL, Main.MASKBITS_BALL, (short)0);

Body body;
float velocityX, velocityY; 
int type;   

public Ball(float pX, float pY, TextureRegion pTextureRegion, PhysicsWorld pWorld, float velocityX, float velocityY, int type) 
{
    super(pX, pY, pTextureRegion);
    this.type = type;
    this.velocityX = velocityX;
    this.velocityY = velocityY;
    body = PhysicsFactory.createCircleBody(pWorld, this, BodyType.DynamicBody, ballFixtureDef);
    body.setUserData(Ball.this);
    pWorld.registerPhysicsConnector(new PhysicsConnector(this, body, true, true));
}
}