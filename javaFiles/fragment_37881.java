public static void main(String args[]) {
    Date d = new Date(System.currentTimeMillis());
    Time t = new Time(System.currentTimeMillis());

    System.out.println("d = " + d);
    System.out.println("t = " + t);

    long dd = d.getTime() / 86400000l * 86400000l;
    System.out.println("dd = " + dd);
    long tt = t.getTime() - (t.getTime() / 86400000l * 86400000l);
    System.out.println("tt = " + tt);

    Timestamp ti = new Timestamp(dd + tt);
    System.out.println("ti = " + ti);
}