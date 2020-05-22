import java.sql.Timestamp;  // extends Date implements Comparable<Date> (!)
 import java.util.Date;

 List<Timestamp> timestamps = ...;
 Date key = ...;
 int index = Collections.binarySearch(timestamps, key);