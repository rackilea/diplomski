public class MonthCountryKey {
     String monthOfBirth;
     String country;
     // <snip> constructor, setters 
     @Override public int hashCode() {
         return Arrays.hashCode(new Object[] {
            monthOfBirth, 
            country,
         });
     }
     @Override public boolean equals(Object o) {
         ...
     }
 }