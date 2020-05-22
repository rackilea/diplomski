private void destroyBall(final Ball ball)
    {
        this.runOnUpdateThread(new Runnable(){

            @Override
            public void run() {

                final Body body = ball.body;
                mPhysicsWorld.unregisterPhysicsConnector(mPhysicsWorld.getPhysicsConnectorManager().findPhysicsConnectorByShape(ball));
                mPhysicsWorld.destroyBody(body);
                mScene.detachChild(ball);
                ballsList.remove(ball);
            }});

    }