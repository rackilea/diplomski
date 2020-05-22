@Override
public void reset(){
    body.setTransform(new Vector2(-50,-50), 0);
    body.setLinearVelocity(0, 0);
    body.setActive(false);
}