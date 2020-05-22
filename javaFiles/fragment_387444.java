Array<Body> bodies = new Array<Body>(world.getBodyCount());
    world.getBodies(bodies);
    for (Body body : bodies) {
        if (BodyUtils.bodyIsBoom(body)) {
            world.destroyBody (body);
          }
        }
    }