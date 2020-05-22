boolean b = false;

for(String neighbour : graph.neighbours(nodeA)) {
        if(!visited.contains(neighbour)) {
           // this statement can never change b to false once it becomes true
           // and you make sure you return after checking your whole set of neighbours
            b = b || isRoute(neighbour, nodeB, visited);
        }
    }

return b;