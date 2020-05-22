Group g = new Group(node);
Scene scene = new Scene(g);
g.applyCss();
g.layout();
double scaleX = node.getBoundsInParent().getWidth();
double scaleY = node.getBoundsInParent().getHeight();