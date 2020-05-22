File file = new File("YOUR_FILE_PATH"); 
    try {
        Scanner scanner = new Scanner(file); 

        scanner.nextLine(); // to ignore the first line which has the header

        ArrayList<GraphNode> graphList = new ArrayList<GraphNode>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(" ");

            // Do something with these values
            graphList.add(new GraphNode(Integer.parseInt(fields[0]),
                                        Integer.parseInt(fields[1]),
                                        Integer.parseInt(fields[2]));

        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }