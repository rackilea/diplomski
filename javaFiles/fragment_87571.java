if (!graph.containsKey(fields[0]))
            {
                n1 = new Node(name);
                graph.put(name, n1);
            }
            else{
                if(graph.containsKey(name)) {
                    n2 = graph.get(name);
                }
                else {
                    n2 = new Node(name);
                    graph.put(name, n2);
                }
                graph.get(fields[0]).addNeighbor(n2);
            }