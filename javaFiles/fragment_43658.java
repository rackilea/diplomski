public static void main(String[] args) {
    String nodes[] = new String[4];
    boolean adjMatrix[][] = new boolean[4][4];

    for (int i = 0; i < 4; i++) {
        nodes[i] = String.valueOf((char) ('A' + i));
    }

    adjMatrix[0][1] = true;
    adjMatrix[1][2] = true;
    adjMatrix[2][3] = true;
    adjMatrix[3][2] = true;
    adjMatrix[2][0] = true;

    ElementaryCyclesSearch ecs = new ElementaryCyclesSearch(adjMatrix, nodes);
    List cycles = ecs.getElementaryCycles();
    for (int i = 0; i < cycles.size(); i++) {
        List cycle = (List) cycles.get(i);
        for (int j = 0; j < cycle.size(); j++) {
            String node = (String) cycle.get(j);
            if (j < cycle.size() - 1) {
                System.out.print(node + " -> ");
            } else {
                System.out.print(node + " -> " + cycle.get(0));
            }
        }
        System.out.print("\n");
    }
}