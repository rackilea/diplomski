public void stopMoving() {
        if (grounded) {
            if (Math.abs(body.getLinearVelocity().x) <= 0.5f)
                body.setLinearVelocity(0, body.getLinearVelocity().y);
            else
                body.applyLinearImpulse(-direction * 0.5f, 0,
                        body.getPosition().x, body.getPosition().y, true);
        } else if (Math.abs(body.getLinearVelocity().x) <= 0.1f)
            body.setLinearVelocity(0, body.getLinearVelocity().y);
        else
            body.applyLinearImpulse(-direction * 0.1f, 0, body.getPosition().x,
                    body.getPosition().y, true);
    }