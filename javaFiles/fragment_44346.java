PathExpanderBuilder peBuilder = PathExpanderBuilder.allTypesAndDirections().remove(RelationshipType.withName(CommonCons.REL_IS_A));
PathFinder<Path> finder = GraphAlgoFactory.shortestPath(peBuilder.build(), CommonCons.MAX_HOP );
Node startNode;
Node endNode;

Path path = finder.findSinglePath(startNode, endNode);