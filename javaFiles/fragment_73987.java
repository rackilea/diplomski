// gets x force based on angle
        float x = (float)Math.sin(body.getAngle() - Math.PI); // minus PI as objects start off facing right
        // gets y force based on angle
        float y = (float)Math.cos(body.getAngle());

        //apply force to center (applies force to middle so no rotation )
        //body.applyForceToCenter( new Vector2(
        //      body.getMass()* (x * 12),
        //      body.getMass()*(y*12)), true);

        //NOTE: bodies must be set to .fixedRotation = false in order to rotate;

        //apply force to a point on body (will create rotational force ) 
        body.applyForce( new Vector2(
                body.getMass()* (x * 12),//x force to apply
                body.getMass()* (y * 12)), //y force to apply
                // apply force to body at 0.5f(halfway for 1f wide object) x and -5 y
                body.getWorldPoint(new Vector2(0.5f,-5)),true);