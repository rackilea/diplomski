public static void main(String[] args){

    JSONArray jArray = new JSONArray();

    Random generator = new Random();
    int [][] grid;

    grid = new int[128][14];

    for (int row = 0; row < 128; row++){
        JSONArray da = new JSONArray();
        for (int col = 0; col < 14; col++){
            grid[row][col] = generator.nextInt(100);
            da.add(grid[row][col]);
        }
        jArray.add(da);
    }
    System.out.println(jArray);

}