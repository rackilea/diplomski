HashMap<String,String>[] harr = new HashMap[10];
final DateFormat df = new SimpleDateFormat("kk:mm");
// prepare your data
for(int i=0;i<harr.length;i++) {
   HashMap<String,String> child=new HashMap<String,String>();
   int ss = (int)(Math.random() * (59 + 1));
   //time changes per iteration(time is in 24-hour format)
   child.put("some_time", String.format("21:%02d", ss));
   harr[i]=child;
}
System.out.printf("map array is: %s%n", Arrays.deepToString(harr));

// now apply sort using a custom method
Arrays.sort(harr, new Comparator<HashMap<String,String>>() {
    public int compare(HashMap<String,String> o1, HashMap<String,String> o2) {
       String t1 = o1.get("some_time");
       String t2 = o2.get("some_time");
       try {
           Date dt1 = df.parse(t1);
           Date dt2 = df.parse(t2);
           return dt1.compareTo(dt2);
       } catch (ParseException e) {
           e.printStackTrace();
       }
       return 0;
    }
});
System.out.printf("sorted map array is: %s%n", Arrays.deepToString(harr));