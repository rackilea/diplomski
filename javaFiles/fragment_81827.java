public class MyEntry implements Comparable<MyEntry> {
     private String theStringToSortOn;

     private String theOtherString;
     private int theFirstInt;
     private int theSecondInt;
     // ...

     public int compareTo(final MyEntry entry) {
          int comparison = String.compare(this.theStringToSortOn, entry.theStringToSortOn);
          if (comparison != 0) {
              return comparison;
          }
          // Do some other rudimentary sorting based on the other fields of the class.
     }
}