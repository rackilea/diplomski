if (aPress) {
    rotate = (rotate - rotSpd + 360) % 360;
}
if (dPress) {
    rotate = (rotate + rotSpd) % 360;
}
if (wPress) {
    x += Math.cos(Math.toRadians(rotate));
    y += Math.sin(Math.toRadians(rotate));
}
if (sPress) {
    x -= Math.cos(Math.toRadians(rotate));
    y -= Math.sin(Math.toRadians(rotate));
}