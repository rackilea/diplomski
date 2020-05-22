public void BFS(Coordinates node,int[][] matrix){
    if(matrix[node.row][node.col] == 0)
        return;
    List<Coordinates> queue = new ArrayList<>();
    queue.add(node);
    for (int i = 0; i < queue.size(); ++i) {
        Coordinates temp = queue.get(i);
        for(int[] dir:dirs){
            int r = temp.row + dir.row;
            int c = temp.col + dir.col;
            if(r < 0 || c < 0 || r >= matrix.length || c >= matrix[r].length)
                continue;
            Coordinates newCoord = new Coordinates(r, c);
            if (!queue.contains(newCoord)) {
                queue.add(newCoord);
            }
            if(matrix[r][c] == 0){
                matrix[temp.row][temp.col] = Math.min(step,matrix[temp.row][temp.col]);
            }
        }
    }
    return;
}