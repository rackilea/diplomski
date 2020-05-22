for (int i = 0; i < 4; i++) {
    int lineX = (int) radius * Math.cos(angle);
    int lineY = (int) radius * Math.sin(angle));

    g.drawLine(circleX + lineX , circleY + lineY , circleX + lineX * legLength, circleY + lineY * legLength);
    angle += legOffset;
}