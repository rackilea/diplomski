public Ball (World world){


        this.world = world;


        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.DYNAMIC;
        bodyDef.position.set(0.0f/RATE, 0.0f/RATE);
        Ballbody = world.createBody(bodyDef);

        CircleShape circle = new CircleShape();
        radius = (int) (Math.random()*30+15); // you can set a non randum raduis 
        circle.m_radius = radius/RATE;

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.restitution = 0.8f;
        fixtureDef.density = 2.0f;
        fixtureDef.friction = 0.3f;
        fixtureDef.filter.groupIndex = -1;
        Ballbody.createFixture(fixtureDef);
        Ballbody.getFixtureList().setUserData("Ballounaton"); // optional 

        Vec2 ballVec = new Vec2((float) (Math.random()*8+2),0.0f);
        Ballbody.setLinearVelocity(ballVec);

    }