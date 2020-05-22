public static void main(String[] args) {
    // TODO Auto-generated method stub

    int[][] array = { {5, 8, 10, 6},
            {20, 10, 20, 15},
            {20, 15, 25, 20}, 
            {20, 20, 32, 25} };
    int query = 20;

    int search_status = 0;

    for (int c = 0; c < array.length; c++)
        search_status += count(array, query, c);

    System.out.println(query + " occurred " + search_status + " times");

}

public static int count(int[][]array, int query, int row){
    int[] column = new int[array.length];
    int count = 0;
    int low = 0;
    int high = column.length - 1;

    for (int i = 0; i < array[row].length; i++)
        column[i] = array[i][row];

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (column[mid] > query) {
            high = mid - 1;
        }
        else if (column[mid] < query) {
            low = mid + 1;
        }
        else if (column[mid] == query) {
            int mover = -1;
            int counted = 1;

            // Go all the way down
            while ((mid + mover >= 0) && (column[mid + mover] == query))
            {
                mover--;
                counted++;
            }

            mover+=counted+1;
            count+=counted;

            while ((mid + mover <= column.length - 1) && (column[mid + mover] == query))
            {
                mover++;
                count++;
            }

            return count;
        }
    }

    return 0;
}