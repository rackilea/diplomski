while(bfs(source, destination, path)) {
        ...
        System.out.println("Before updating with "+minCap);
        printPath(path);

        // updates the maxFlow
        ....

        System.out.println("After  updating with "+minCap);
        printPath(path);

        ...
    }