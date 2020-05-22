String[] lines = new String[3];
    lines[0] = "Michael 25 Award_1";
    lines[1] = "Ana 15 Award_2";
    lines[2] = "Bruno 50 Award_3";

    String[] parts;
    Map<String, String> linesByName = new TreeMap<String, String>();        
    Map<Integer, String> linesByAge = new TreeMap<Integer, String>();

    for (String line : lines) {
        parts = line.split(" ");
        linesByName.put(parts[0], line);
        linesByAge.put(Integer.parseInt(parts[1]), line);
    }

    System.out.println("Sorted by Name:");

    for (Map.Entry<String, String> entry : linesByName.entrySet()) {
        System.out.println(entry.getValue());
    }

    System.out.println("\nSorted by Age:");

    for (Map.Entry<Integer, String> entry : linesByAge.entrySet()) {
        System.out.println(entry.getValue());
    }