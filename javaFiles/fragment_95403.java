public static SparseVector combineSparseVectors(SparseVector... svs) {
    int size = 0;
    int nonzeros = 0;
    for (SparseVector sv : svs) {
        size += sv.size();
        nonzeros += sv.indices().length;
    }

    if (nonzeros != 0) {
        int[] indices = new int[nonzeros];
        double[] values = new double[nonzeros];

        int pointer_D = 0;
        int totalPt_D = 0;
        int pointer_V = 0;
        for (SparseVector sv : svs) {
            int[] indicesSV = sv.indices();
            for (int i : indicesSV) {
                indices[pointer_D++] = i + totalPt_D;
            }
            totalPt_D += sv.size();

            double[] valuesSV = sv.values();
            for (double d : valuesSV) {
                values[pointer_V++] = d;
            }

        }
        return new SparseVector(size, indices, values);
    } else {
        System.out.println("all zeroes");
        return null;
    }

}