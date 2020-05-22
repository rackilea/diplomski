this.mScene = new Scene();
        this.mScene.setBackground(new Background(0, 0, 0));
        this.mScene.setOnSceneTouchListener(this);
        this.mScene.setOnAreaTouchListener(this);

        this.mPhysicsWorld = new PhysicsWorld(new Vector2(0, 10), false);
        this.mScene.registerUpdateHandler(this.mPhysicsWorld);

        final Rectangle ground = new Rectangle(0, CAMERA_HEIGHT - 2, CAMERA_WIDTH, 2, vertexBufferObjectManager);
        final Rectangle left = new Rectangle(0, 0, 2, CAMERA_HEIGHT, vertexBufferObjectManager);
        final Rectangle right = new Rectangle(CAMERA_WIDTH - 2, 0, 2, CAMERA_HEIGHT, vertexBufferObjectManager);
        Body g =PhysicsFactory.createBoxBody(this.mPhysicsWorld, ground, BodyType.StaticBody, wallFixtureDef2);
        Body l =PhysicsFactory.createBoxBody(this.mPhysicsWorld, left, BodyType.StaticBody, wallFixtureDef1);

        final float width = 2*g.getWorldCenter().x;
        final float height = 2*l.getWorldCenter().y;