if (vx > 0) {
    vx -= Math.min(0.1, vx);
}
if (vx < 0) {
    vx += Math.min(0.1, -vx);
}