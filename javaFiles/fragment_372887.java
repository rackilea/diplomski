Scanner line = new Scanner(s.nextLine());
            String vertex = line.next();
            String destination = line.next();
            int weight = line.nextInt();     
            g.add(vertex);
            g.add(destination); // <--- ADD THIS LINE!!
            g.addEdge(vertex, destination, weight);