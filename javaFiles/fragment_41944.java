private static String printDependencies(ConcurrentHashMap<String, LinkedList<String>> theTable, LinkedList<String> dependencies, ConcurrentHashMap<String, Boolean> alreadyPrinted) {

    String output = "";

    for (String d : dependencies) {
        boolean isPrinted = alreadyPrinted.containsKey(d);
        if (!isPrinted) {
            output += " " + d;
            alreadyPrinted.put(d, true);
        }           
    }

    for (String d : dependencies) {
        LinkedList<String> key = theTable.get(d);
        if (key != null) {
            LinkedList<String> unvisited = new LinkedList<String>();
            for (String filename : key)
                if (!alreadyPrinted.containsKey(filename))
                    unvisited.add(filename);
            if (unvisited != null)            
                output += printDependencies(theTable, unvisited, alreadyPrinted);               
        }
    }

    return output;
}

private static void printDependencies(ConcurrentHashMap<String, LinkedList<String>> theTable, ConcurrentLinkedQueue<String> toProcess) {
    String output = ""; 

    for (String current : toProcess) {
        ConcurrentHashMap<String, Boolean> alreadyPrinted = new ConcurrentHashMap<String, Boolean>(); // Keeps track of dependencies already printed
        output += current + ":" + printDependencies(theTable, theTable.get(current), alreadyPrinted) + "\n";
    }

    System.out.println(output);     
}