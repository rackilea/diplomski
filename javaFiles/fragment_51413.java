List<Graph> graphs = new ArrayList<>(reports  // we want a list - so let's create one. The rest of the code is just to give it some initial contents 
                    .stream()    // stream of reports
                    .collect(HashMap<String, Graph>::new, //collect them - start with a map of date -> grap
                    (map, report)->{ // here, for each report:
                         // pick a graph instance for the date, create one if it does not exist yet
                         Graph graph = map.computeIfAbsent(report.date, date -> new Graph(report.date));   
                         // Next, populate the graph instance based on report type
                         if ("A".equals(report.type)) { graph.numberA = report.count; }  
                         else if ("B".equals(report.type)) { graph.numberB = report.count; }
                         else if ("C".equals(report.type)) { graph.numberC = report.count; }
                        },
                    Map::putAll) // see collect() javadoc for a description of why this is here
                    .values());  // last step - get all values from the map (it's a Collection)