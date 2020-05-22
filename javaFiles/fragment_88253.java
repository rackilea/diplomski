private Array<Body> array;

@Override
public void create(){         //create or show depending on who is parent
    array=new ArrayList<Body>();
}

@Override
public void render(float delta) {

    ....
    world.getBodies(array);
    for (Body body:array){
        if(body.getType()== BodyDef.BodyType.DynamicBody) { // I've to draw only circle
            shapeRenderer.circle(body.getPosition().x ,body.getPosition().y ,80f);
        }
    }
}