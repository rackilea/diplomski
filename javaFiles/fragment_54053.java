@Override
public void beginContact(Contact contact) {
    //System.out.println("Contact");
    Fixture fa = contact.getFixtureA();
    Fixture fb = contact.getFixtureB();

    if(fa.getBody().getUserData() instanceof Brick){
        this.brickHit((Brick) fa.getBody().getUserData(), fb);
    }else if(fb.getBody().getUserData() instanceof Brick){
        this.brickHit((Brick) fb.getBody().getUserData(), fa);
    }

    if(fa.getBody().getUserData() instanceof Pad){
        this.padHit((Pad) fa.getBody().getUserData(), fb);
    }else if(fb.getBody().getUserData() instanceof Pad){
        this.padHit((Pad) fb.getBody().getUserData(), fa);
    }

    if(fa.getBody().getUserData() instanceof Bin){
        objectInVoid(fb);
    }else if(fb.getBody().getUserData() instanceof Bin){
        objectInVoid(fa);
    }

    if(fa.getBody().getUserData() instanceof Ball){
        ballHitSomething((Ball) fa.getBody().getUserData(),fb);
    }else if(fb.getBody().getUserData() instanceof Ball){
        ballHitSomething((Ball) fb.getBody().getUserData(),fa);
    }

    if(fa.getBody().getUserData() instanceof Bomb){
        bombHitSomething((Bomb) fa.getBody().getUserData(),fb);
    }else if(fb.getBody().getUserData() instanceof Bomb){
        bombHitSomething((Bomb) fb.getBody().getUserData(),fa);
    }

    if(fa.getBody().getUserData() instanceof LocalEffectEntity){
        if(fa.isSensor()){
            inLocalEffectRange((LocalEffectEntity) fa.getBody().getUserData(),fb);
        }else{
            objectInVoid(fb);
        }
    }else if(fb.getBody().getUserData() instanceof LocalEffectEntity){
        if(fb.isSensor()){
            inLocalEffectRange((LocalEffectEntity) fb.getBody().getUserData(),fa);
        }else{
            objectInVoid(fa);
        }
    }
}