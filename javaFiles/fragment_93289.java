int leftSuperiorQuadrant [][] = {{1, 2}, {3, 4}};
    int rightSuperiorQuadrant [][] = {{5, 6}, {7, 8}};
    int leftInferiorQuadrant [][] = {{9, 10}, {11, 12}};
    int rightInferiorQuadrant [][] = {{13, 14}, {15, 16}};

    int m_intermediate_left[][] = new int[leftSuperiorQuadrant.length+leftInferiorQuadrant.length][];
    int m_intermediate_right[][] = new int[rightSuperiorQuadrant.length+rightInferiorQuadrant.length][];

    // Concat leftSuperiorQuadrant and leftInferiorQuadrant in column
    System.arraycopy(leftSuperiorQuadrant, 0, m_intermediate_left, 0, leftSuperiorQuadrant.length);
    System.arraycopy(leftInferiorQuadrant, 0, m_intermediate_left, leftSuperiorQuadrant.length, leftInferiorQuadrant.length);

    // Concat rightSuperiorQuadrant and rightInferiorQuadrant in column
    System.arraycopy(rightSuperiorQuadrant, 0, m_intermediate_right, 0, rightSuperiorQuadrant.length);
    System.arraycopy(rightInferiorQuadrant, 0, m_intermediate_right, rightSuperiorQuadrant.length, rightInferiorQuadrant.length);

    System.out.println(Arrays.deepToString(m_intermediate_left));
    System.out.println(Arrays.deepToString(m_intermediate_right));