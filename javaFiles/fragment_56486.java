float dx = touchpad.getKnobPercentX();
float dy = touchpad.getKnobPercentY();

int direction = Math.floor((Math.atan2(dy, dx) + Math.PI/8) / (2*Math.PI/8));
if (direction == 8) direction = 0;
double angle = direction * (Math.PI/4);

player.setX(player.getX() + Math.cos(angle) * Constants.SPEED);
player.setY(player.getY() + Math.sin(angle) * Constants.SPEED);