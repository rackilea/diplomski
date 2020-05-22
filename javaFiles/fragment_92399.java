public class SortbyViewComparator implements Comparator<abc> {

   public int compare(abc object1, abc object2) {

      if (object1.getViewDesc() == null && object2.getViewDesc() == null) {
            return 0;

        } else if (object1.getViewDesc() == null) {
            return -1;

        } else if (object2.getViewDesc() == null) {
            return 1;
        }

        return object1.getViewDesc().compareTo(object2.getViewDesc());
   }
}