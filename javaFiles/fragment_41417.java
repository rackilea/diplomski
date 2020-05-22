public class Main {

private static int GATE_COST = 1;
private static BinaryTree bt;
private static ArrayList<Node> arrNodes;
private static int currDepth = 0;

public static void main(String[] args) throws IOException {
    File filePin = new File("C:/Users/Arindam/workspace/TreeSynthesis/files/pin.txt");
    BufferedReader buffer = new BufferedReader(new FileReader(filePin));
    String line = buffer.readLine();
    int lenData = Integer.parseInt(line.trim());
    float[] data = new float[lenData];
    for (int i = 0; i < lenData; i++) {
        line = buffer.readLine();
        data[i] = Float.parseFloat(line.trim());
    }
    arrNodes = new ArrayList<Node>();
    bt = new BinaryTree();
    String arrival = sysnthesis(data);
    System.out.println("Arrival: " + arrival);
    System.out.println("Topology: ");
    bt.printPostorder();
}

private static String sysnthesis(float[] data) {
    ArrayList<Node> dataNodes = convertArraytoNode(data);
    while (dataNodes.size() > 1) {
        for (int i = 0; i < dataNodes.size(); i++) { 
            System.out.print(dataNodes.get(i).getData() + " ");
        }
        float[] cost = getCost(dataNodes);

        float minValue = cost[0];
        int minIndex = 0;
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] < minValue) {
                minValue = cost[i];
                minIndex = i;
            }
        }
        createTree(dataNodes, minValue, minIndex);
        dataNodes = getNewDataNodes(dataNodes, minValue, minIndex);
        //bt.printPostorder();
        System.out.println();
    }
    System.out.print(dataNodes.get(0).getData()+ "\n");
    return dataNodes.get(0).getData();
}

private static ArrayList<Node> convertArraytoNode(float[] data) {
    ArrayList<Node> dataNodes = new ArrayList<Node>();
    for (int i = 0; i < data.length; i++) {
        dataNodes.add(new Node(Float.toString(data[i]), 0));
    }
    return dataNodes;
}

private static float[] getCost(ArrayList<Node> dataNodes) {
    float[] cost = new float[dataNodes.size() - 1];
    for (int i = 0; i < dataNodes.size() - 1; i++) {
        cost[i] = Math.max(Float.parseFloat(dataNodes.get(i).getData()), 
                Float.parseFloat(dataNodes.get(i+1).getData())) + GATE_COST; 
    }
    return cost;
}

private static ArrayList<Node> getNewDataNodes(ArrayList<Node> dataNodes, float minValue, int minIndex) {
    dataNodes.get(minIndex).setData(Float.toString(minValue));
    dataNodes.get(minIndex).setDepth(currDepth);
    dataNodes.remove(minIndex + 1);
    return dataNodes; 
}


private static void createTree(ArrayList<Node> dataNodes, float minValue, int minIndex) {
    Node root = null, lChild = null, rChild = null;
    root = new Node(Float.toString(minValue), ++currDepth);
    int flag = 0;
    ArrayList<Integer> deleteIndex = new ArrayList<Integer>();
    if (!arrNodes.isEmpty()) {
        for (int i = 0; i < arrNodes.size(); i++) {
            if (arrNodes.get(i).getData().equals(dataNodes.get(minIndex).getData()) &&
                    dataNodes.get(minIndex).getDepth() == currDepth - arrNodes.size() + i) {
                flag++;
                lChild = arrNodes.get(i);
                deleteIndex.add(i);
            }
            else if (arrNodes.get(i).getData().equals(dataNodes.get(minIndex + 1).getData()) &&
                    dataNodes.get(minIndex + 1).getDepth() == currDepth - arrNodes.size() + i) {
                flag++;
                rChild = arrNodes.get(i);
                deleteIndex.add(i);
            }
        }
        if (flag == 0) {
            lChild = new Node(dataNodes.get(minIndex).getData(), 0);
            rChild = new Node(dataNodes.get(minIndex + 1).getData(), 0);
        } else if (flag == 1 && null ==  rChild){
            rChild = new Node(dataNodes.get(minIndex + 1).getData(), 0);
        } else if (flag == 1 && null ==  lChild) {
            lChild = new Node(dataNodes.get(minIndex).getData(), 0);
        }
        for (int i = deleteIndex.size() - 1; i > 0; i--) {
            dataNodes.remove(deleteIndex.get(i));
        }
    } else {
        lChild = new Node(dataNodes.get(minIndex).getData(), 0);
        rChild = new Node(dataNodes.get(minIndex + 1).getData(), 0);
    }
    bt.buildTree(root, lChild, rChild);
    arrNodes.add(bt.getRootNode());
}
}