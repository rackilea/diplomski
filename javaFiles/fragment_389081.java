public void move() {
    calculatePitch();
    calculateAngleAroundPlayer();
    this.yaw = 180 - (player.getRotY() + angleAroundPlayer);
    yaw %= 360;
}