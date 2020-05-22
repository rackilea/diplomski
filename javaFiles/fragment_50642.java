String[][][] result = new String[d3.size()][][];
for (int i = 0; i < result.length; i++) {
    result[i] = new String[d3.get(i).size()][];
    for (int j = 0; j < result[i].length; j++) {
        result[i][j] = new String[d3.get(i).get(j).size()];
        for (int k = 0; k < result[i][j].length; k++) {
            result[i][j][k] = d3.get(i).get(j).get(k);
        }
    }
}

System.out.println(Arrays.deepToString(result)); //see if result is ok