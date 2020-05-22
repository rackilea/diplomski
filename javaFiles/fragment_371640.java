public class SmsComparator implements `Comparator<Sms>` {
    @Override
    public bool compare(Sms o1, Sms o2) {
       if(o1.getA() > o2.getA()) return 1;
       else if(o1.getA() > o2.getA()) return -1;
       else return 0;
    }
 }