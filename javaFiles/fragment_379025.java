double c = 1 / 60; // Some constant factor to bound motion over time
long previousCycleTime = System.currentTimeMillis();
while(somePredicate()) { // Logical cycle
   long t = System.currentTimeMillis() - previousCycleTime;
   gameObjects.forEach( o -> {
     // t -> time passage
     // dx -> change on the x axis
     // c -> some constant factor to bound movement to the 'virtual space'
     o.x += o.dx * t * c; 
     o.y += o.dy * t * c;
   }
   redraw();
}