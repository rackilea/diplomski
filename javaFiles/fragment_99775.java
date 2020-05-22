private void findRingWithMatrix(String... words) {
    System.out.println("For example: " + Arrays.toString(words));
    boolean[][] initialAdjacencyMatrix = new boolean[words.length][words.length];
    List<String[]> paths = new ArrayList<>();
    //Build initial adjacency matrix
    for (int i = 0; i < words.length; i++) {
        for (int j = 0; j < words.length; j++) {
            initialAdjacencyMatrix[i][j] = (i != j) && (couldBeInChain(words[i], words[j]));
            //if node is reachable
            if (initialAdjacencyMatrix[i][j]) {
                //put this path to possible paths
                paths.add(new String[]{words[i], words[j]});
            }
        }
    }

    //create temporary copy of matrix to multiply
    boolean[][] tempAdjacencyMatrix = initialAdjacencyMatrix.clone();

    //We should multiply matrix N-1 times, because first step in graph we've already done on previous step
    for (int n = 1; n < words.length; n++) {
        boolean[][] bufferAdjacencyMatrix = new boolean[words.length][words.length];

        List<String[]> newPathes = new ArrayList<>();

        //multiply matrices (next step and initial). In result we get [true] in node which is reachable from first node in N steps
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                for (int k = 0; k < words.length; k++) {
                    bufferAdjacencyMatrix[i][j] |= (tempAdjacencyMatrix[i][k] && initialAdjacencyMatrix[k][j]);
                }
                //if node reachable
                if (bufferAdjacencyMatrix[i][j]) {
                    //create new path and put it list of possible paths
                    for (String[] path : paths) {
                        if (couldBeInChain(path[path.length - 1], words[j])) {
                            String[] newPath = new String[path.length + 1];
                            System.arraycopy(path, 0, newPath, 0, path.length);
                            newPath[newPath.length - 1] = words[j];
                            newPathes.add(newPath);
                        }
                    }
                }
            }
        }
        paths = removeDuplicates(newPathes);
        System.out.println("Step #" + n);
        printMatrix(bufferAdjacencyMatrix);
        tempAdjacencyMatrix = bufferAdjacencyMatrix;
    }

    boolean isRing = true;

    //Ring could be just if after (N-1) multiplications we have [true] in main diagonal.
    //In other words, can reach every node in N steps.
    for (int i = 0; i < words.length; i++) {
        isRing = tempAdjacencyMatrix[i][i];
        if (!isRing) {
            break;
        }
    }

    if (!isRing) {
        System.out.println("NO SOLUTION");
        return;
    } else {

        System.out.println("Found solutions:");
        for (String[] path : paths) {
            //we are interested just in solutions when first node is equals to last one
            if (path[0].equals(path[path.length - 1])) {
                String[] toPrint = new String[path.length - 1];
                System.arraycopy(path, 0, toPrint, 0, toPrint.length);
                System.out.println(Arrays.deepToString(toPrint));
            }
        }
    }

    System.out.println("==============================");
}

private boolean couldBeInChain(String first, String second) {
    return first.charAt(first.length() - 1) == second.charAt(0);
}

private List<String[]> removeDuplicates(List<String[]> newPathes) {
    return newPathes
            .stream()
            .map(Arrays::asList)
            .collect(Collectors.collectingAndThen(Collectors.toSet(), new Function<Set<List<String>>, List<String[]>>() {
                @Override
                public List<String[]> apply(Set<List<String>> lists) {
                    List<String[]> result = new ArrayList<>();
                    for (List<String> list : lists) {
                        result.add(list.toArray(new String[list.size()]));
                    }
                    return result;
                }
            }));
}

private void printMatrix(boolean[][] matrix) {
    System.out.println("-------------------------------");

    for (boolean[] row : matrix) {
        System.out.println(Arrays.toString(row));
    }
    System.out.println("-------------------------------");
}