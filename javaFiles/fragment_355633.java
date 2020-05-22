List<Double> values = new ArrayList<>();
List<Integer> nodes = new ArrayList<>();
int c = 0;
File file = new File("text.txt");
BufferedReader reader = null;

double[][] graph2 = null;    

try {
    reader = new BufferedReader(new FileReader(file));
    String text = null;
    while ((text = reader.readLine()) != null) {
        // The first line gives the number of nodes (You will use to create the int[][] graph = new int[nOfNodes][nOfNodes];)
        if (c == 0) {
            numberOfNodes = Integer.parseInt(text.trim());
        }
        // The second one gives the number of edges
        else if (c == 1) {
            nOfEdges = Integer.parseInt(text.trim());
            graph2 = new double[nOfEdges][3];
        }
        // And third the list of special nodes
        // `nodes` will now contains only your special constrained one
        else if (c == 2) {
            String[] str = text.split(" ");
            for (int i = 0; i < str.length; i++) {
                if (str[i].trim().length() > 0) {
                    nodes.add(Integer.parseInt(str[i]));
                }
            }
        } else { // Then you have your edges descriptors
            String[] str = text.split(" ");
            for (int i = 0; i < str.length; i++) {
                if (str[i].trim().length() > 0) {
                     graph2[c-4][i] = Double.parseDouble(str[i]);                     
                }
            }
        }
        c++;
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        if (reader != null) {
            reader.close();
        }
    } catch (IOException e) {
        System.out.print(e);
    }
}