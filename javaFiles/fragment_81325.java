class DTMSlowSorter {
   /**
    */
   private DefaultTableModel model;
   /**
    * the number of the column by which we want to sort
    */
   private int sortColNum;
   /**
    * the comparator for the elements.
    */
   private Comparator comparator;

   /**
    * The time to sleep between two sorting steps.
    */
   private int sleepTime = 500;

   /**
    * swaps the contents of two rows.
    */
   void swap(final int rowA, final int rowB) {
        try {
            EventQueue.invokeAndWait(new Runnable(){public void run() {
                int colCount = model.getColumnCount();
                Object[] temp = new Object[colCount];
                for(int i = 0; i < colCount; i++) {
                   temp[i] = model.getValueAt(rowA, i);
                }
                for(int i = 0; i < colCount; i++) {
                   model.setValueAt(model.getValueAt(rowB, i), rowA, i);
                }
                for(int i = 0; i < colCount; i++) {
                   model.setValueAt(temp[i], rowA, i);
                }
            }});
           Thread.sleep(sleepTime);
        } catch(InterruptedException ex) { ex.printStackTrace();}
   }

   /**
    * compares two rows.
    * @returns
    *      -1 if  A < B
    *       0 if  A = B
    *       1 if  A > B
    */
   int compare(int rowA, int rowB) {
       Object valA = model.getValueAt(rowA, sortColNum);
       Object valB = model.getValueAt(rowB, sortColNum);
       if(comparator != null) {
          return comparator.compare(valA, valB);
       }
       else {
          return ((comparable)valA).compareTo(valB);
       }
   }

   public void sort() {
      // here your bubblesort implementation, using compare and swap.
   }

}