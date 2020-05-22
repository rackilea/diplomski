List<double[][]> list = Arrays.asList(
        new double[][]{{1.0, 0.0, 0.0}, {0.0, 0.0, 0.0}},
        new double[][]{{0.0, 0.0, 0.0}, {1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}});

double[][] result = list.stream()
        .flatMap(Arrays::stream)
        .toArray(double[][]::new);