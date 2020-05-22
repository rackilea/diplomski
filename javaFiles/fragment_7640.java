List<RoadElement> RoadMap = new LinkedList<RoadElement>();
   Road r1 = new Road();
   Intersection i1 = new Intersection();
   r1.setPrevious(i1);
   i1.setNorthernConnection(r1);
   ....