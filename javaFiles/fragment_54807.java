public void update(float delta){



        physicsWorld.step(delta, 2, 2);



        for(int i=0;i<BoxList.size();i++){
            DynamicBox b = BoxList.get(i);
            if(b.shouldRemove==true){
                physicsWorld.destroyBody(b.boxerino);
                BoxList.remove(i);
            }
        }
    }