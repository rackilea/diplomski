public class BlockedWidthList<T> {

    public static void main(String[] args) {
        BlockedWidthList<Integer> myList = new BlockedWidthList<Integer>(6);
        for(int i = 0; i < 20; i++)
            myList.add(i);
        for(Integer entry : myList.getRow(2))
            System.out.println(entry);
    }

    /** @throws java.lang.IllegalArgumentException if 'blockedWidthSize' is less than or equal to zero */
    public BlockedWidthList(int blockedWidthSize){
        if(blockedWidthSize<1)
            throw new IllegalArgumentException("Width must be a positive number");
        this.blockedWidthSize = blockedWidthSize;
    }

    public final int blockedWidthSize;

    private List<T> internal = new ArrayList<T>();

    public void add(T elem){
        internal.add(elem);
    }

    /** Access a row in the blocked width list by a row index. Indexing starts at 0
      *
      * @return A list containing up to 'blockedWidthSize' elements
      * @throws java.lang.IndexOutOfBoundsException if the row does not exist
      */
    public List<T> getRow(int rowIndex){
        if (rowIndex < 0) throw new IndexOutOfBoundsException("Negative row");
        int startIdx = rowIndex * blockedWidthSize;
        return internal.subList(startIdx, startIdx + blockedWidthSize);
    }
}