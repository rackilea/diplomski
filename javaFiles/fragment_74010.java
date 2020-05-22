public class Date {

     private transient long fastTime;

     ....

     public long getTime() {
         return getTimeImpl();
     }

     ....

     public boolean equals(Object obj) {
         return obj instanceof Date && getTime() == ((Date) obj).getTime();
     }
}

public class Timestamp extends java.util.Date {

    public boolean equals(java.lang.Object ts) {
        if (ts instanceof Timestamp) {
        return this.equals((Timestamp)ts);
        } else {
        return false;
        }
    }

    public boolean equals(Timestamp ts) {
        if (super.equals(ts)) {
            if  (nanos == ts.nanos) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}