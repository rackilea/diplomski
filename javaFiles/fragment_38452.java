private Body makeObstacle(World world, BodyDef.BodyType type) {

    BodyDef bdef = new BodyDef();
    bdef.type = type;
    bdef.position.set(7, randomYPos);
    Body body = world.createBody(bdef);


    body.setLinearVelocity(-4, 0);

    PolygonShape shape = new PolygonShape();

    shape.setAsBox(60 / RadiationPigeon.PPM, 25 / RadiationPigeon.PPM);

    FixtureDef fdef = new FixtureDef();
    fdef.shape = shape;


    body.createFixture(fdef);

    return body;
}