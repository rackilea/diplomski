void playerController() {
     if (!playerControllerBottonTouched) { // or actor.isTouched()
        playerBody.setLinearVelocity(shipBody.getLinearVelocity().x, 
                                     shipBody.getLinearVelocity().y);
     } else {
           playerBody.applyLinearImpulse(*impulse that you want*);
       }
}