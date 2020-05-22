System.out.println(nicksGraph.findPath(
    nicksGraph.nodeWith(new Coordinate(0,0)),
    // Replacement anonymous inner class here.
    new Predicate<Coordinate>() {
       @Override
       public boolean test(Coordinate a) {
          // return the lambda expression here.
          return a.getX()==3 && a.getY()==1;
       }
    },
    new PriorityQueue<Node<Coordinate>, Integer>(funcTotal)));