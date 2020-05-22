List<int[]> searchForArrays(int[][] data, int[] value) {
    return Arrays.stream(data).parallel()
        .filter(line -> {
            for (int i = 0; i < value.length; i++)
                if (i >= line.length || value[i] != line[i])
                    return false;
            return true;
        });
        .collect(Collectors.toList());
}