public void jump() {
        if (jumpDelta >= Constants.PLAYER_JUMP_RATE) {
            grounded = level.getContactListener().numFootContacts > 0;
            if (grounded) {
                body.setLinearVelocity(body.getLinearVelocity().x, 7);
                jumpDelta = 0;
            }
        }
    }