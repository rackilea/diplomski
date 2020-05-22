// create and fill a matrix of the right dimensions
int[][] matrix = new int[3][3];

// create a map that maps row/col names to indexes
Map<String, Integer> map = new HashMap<String, Integer>();
map.put("val1", 0);
map.put("val2", 1);
map.put("val3", 2);

// the actual method is straightforward
public int getValue(String name1 , String name2) {
    int i = map.get(name1);
    int j = map.get(name2);
    return matrix[i][j];
}