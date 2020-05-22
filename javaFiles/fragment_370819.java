private ContactListener mContactListener = new ContactListener() { 
/**
 * Called when two fixtures begin to touch.
 */
public void beginContact (Contact contact) {
    final Body bodyA = contact.getFixtureA().getBody();
    final Body bodyB = contact.getFixtureB().getBody();

    if(bodyA.getUserData().equals(PLAYER_ID)) {
        if(bodyB.getUserData().equals(GROUND_ID))
            mIsJumping = false;
    }
    else if(bodyA.getUserData().equals(GROUND_ID)) {
        if(bodyB.getUserData().equals(PLAYER_ID))
            mIsJumping = false;
    }

}

/**
 * Called when two fixtures cease to touch.
 */
public void endContact (Contact contact) { }

/**
 * This is called after a contact is updated.
 */
public void preSolve(Contact pContact) { }

/**
 * This lets you inspect a contact after the solver is finished. 
 */
public void postSolve(Contact pContact) { }
};