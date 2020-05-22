if (input.isKeyDown(Input.KEY_W))
    {

        dx += Math.sin(Math.toRadians(image.getRotation())) * delta * 0.01;
        dy += -Math.cos(Math.toRadians(image.getRotation())) * delta * 0.01;

    } 

    x += dx;
    y += dy;

    dx *= 0.98;
    dy *= 0.98;