if (position.x > 2560) {
        velocity.add(0, 0, 0);
    }
    else {
        velocity.add(2 * SP, 0, 0);
    }
    velocity.scl(dt);
    position.add(velocity.x, 0, 0);
    velocity.scl(1/dt);