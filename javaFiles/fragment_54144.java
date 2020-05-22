transform1 = g2.getTransform();

double newWidth1 = 301;
double newHeight1 = 427;

transform1.translate(newWidth1, newHeight1);

g2.transform(transform1);
g2.setColor(Color.blue);
g2.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
g2.draw(outline1);

textTl.draw(g2, 0, 0);