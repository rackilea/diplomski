FixtureDef fixtureDef = new FixtureDef();
            fixtureDef.shape = circle;
            fixtureDef.restitution = 0.8f;
            fixtureDef.density = 2.0f;
            fixtureDef.friction = 0.3f;
            fixtureDef.filter.groupIndex = -1;
            Ballbody.createFixture(fixtureDef);