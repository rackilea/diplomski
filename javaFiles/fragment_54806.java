Vector3 testPoint = new Vector3();
    QueryCallback callback = new QueryCallback() {

        @Override
        public boolean reportFixture(Fixture fixture) {
            if(fixture.testPoint(testPoint.x,testPoint.y)){
                hitBody = fixture.getBody();
                return false;
            }else{
                return true;
            }

        }
    };

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        GameRender.cam.unproject(testPoint.set(screenX,screenY,0));
        hitBody = null;
        GameWorld.physicsWorld.QueryAABB(callback, testPoint.x - 0.0001f,
                                        testPoint.y - 0.0001f,
                                        testPoint.x + 0.0001f,
                                        testPoint.y + 0.0001f);

        for(DynamicBox b:GameWorld.BoxList){
            if(hitBody == b.boxerino){
                System.out.println("click detected");
                b.shouldRemove = true;
            }
        }

        return false;
    }