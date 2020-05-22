Interactive currentInteractive = interactiveList.get(i);

currentInteractive.draw();

float angle = (float)Math.toDegrees(Math.atan2(currentInteractive.getY()-player.pos[1], currentInteractive.getX()-player.pos[0]));

arrow.setRotation(angle+90);

float magnitude;
float abs_cos_angle = (float) Math.abs(Math.cos(Math.toRadians(angle)));
float abs_sin_angle = (float) Math.abs(Math.sin(Math.toRadians(angle)));
if (Main.DISPLAY_WIDTH/2*abs_sin_angle <= Main.DISPLAY_HEIGHT/2*abs_cos_angle)
{
    magnitude = (Main.DISPLAY_WIDTH-20)/2/abs_cos_angle;
}
else
{
    magnitude = (Main.DISPLAY_HEIGHT-20)/2/abs_sin_angle;
}

float ax;
if(currentInteractive.pos[0] > player.pos[0]-(Main.DISPLAY_WIDTH/2) && currentInteractive.pos[0] < player.pos[0]+(Main.DISPLAY_WIDTH/2))
{
    ax = (float) currentInteractive.pos[0];
}
else
{
    ax = (float) (Math.cos(Math.toRadians(angle)) * magnitude) + camera.viewPort.getCenterX()-10;
}

float ay;
if(currentInteractive.pos[1] > player.pos[1]-(Main.DISPLAY_HEIGHT/2) && currentInteractive.pos[1] < player.pos[1]+(Main.DISPLAY_HEIGHT/2))
{
    ay = (float) currentInteractive.pos[1];
}
else
{
    ay = (float) (Math.sin(Math.toRadians(angle)) * magnitude) + camera.viewPort.getCenterY()-10;
}

arrow.draw(ax, ay, Color.green);