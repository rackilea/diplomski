while (!pi.isDone() && Point2D.distance(puntos[0],puntos[1],cursor[0],cursor[1]) < 10){
    pi.next();
    if (!pi.isDone())
        pi.currentSegment(puntos);
    }
}