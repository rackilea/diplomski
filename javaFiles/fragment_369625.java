// Back
/* First parallax for back layer is at 0 x-axis. If you want to move the texture from right to left, the value of BACK_VELOCITY_X should be negative. You can experiment with velocity value for desire pace of movement. We do not want our layer to move on y-axis. Hence, it is set to 0. */

parallaxList.add(new Parallax(0, BACK_TEXTURE_HEIGHT, BACK_TEXTURE_WIDTH, BACK_TEXTURE_HEIGHT, BACK_VELOCITY_X, 0));

/* This one is also for back layer but it is positioned at the right edge of the layer above*/
parallaxList.add(new Parallax(BACK_TEXTURE_WIDTH, BACK_TEXTURE_HEIGHT, BACK_TEXTURE_WIDTH, BACK_TEXTURE_HEIGHT, SOME_VELOCITY_X, 0));

// Front
parallaxList.add(new Parallax(0, 0, FRONT_TEXTURE_WIDTH, FRONT_TEXTURE_HEIGHT, FRONT_VELOCITY_X, 0));
parallaxList.add(new Parallax(FRONT_TEXTURE_WIDTH, 0, FRONT_TEXTURE_WIDTH, FRONT_TEXTURE_HEIGHT, FRONT_VELOCITY_X, 0));