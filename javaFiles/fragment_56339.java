Path2D path = new Path2D.Double();
path.moveTo(0, value[0]);
for(int angle=1 ; angle< 360; angle++){
    double rad = angle*Math.PI/180.0;
    path.lineTo(value[i]*Math.cos(rad), value[i]*Math.sin(rad));
}
g2d.translate(originx, originy);
g2d.scale(scale, scale);
g2d.draw(path);