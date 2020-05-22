62         if (distanceThroughU < v.minDistance) {
 63             vertexQueue.remove(v);
 64 
 65             v.minDistance = distanceThroughU ;
 66             v.previous = u;
 67             vertexQueue.add(v);
 68         }