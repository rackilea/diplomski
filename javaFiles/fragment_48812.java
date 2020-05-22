System.out.println("List of Cities:");

        for (Vertex v : vertices)
         {
        System.out.println(v);
        }
        Scanner k = new Scanner(System.in);
        System.out.println("\nEnter start location: ");
        int start = k.nextInt();
        System.out.println("Enter destination: ");
        int destination = k.nextInt();

        computePaths(vertices[start]);
         System.out.println("\nDistance to " + vertices[destination] + ": " + vertices[destination].minDistance);
         List<Vertex> path = getShortestPathTo(vertices[destination]);
         System.out.println("Path: " + path);
    }