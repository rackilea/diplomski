public void preSolve(Contact contact, Manifold oldManifold) {

    if (contact.getFixtureA().getBody().getUserData() instanceof ConveyorBelt){
        ConveyorBelt conveyorBelt = (ConveyorBelt) contact.getFixtureA().getBody().getUserData();
        conveyorBelt.preSolve(contact, oldManifold);

    }else if (contact.getFixtureB().getBody().getUserData() instanceof ConveyorBelt){
        ConveyorBelt conveyorBelt = (ConveyorBelt) contact.getFixtureB().getBody().getUserData();
        conveyorBelt.preSolve(contact, oldManifold);
    }
}