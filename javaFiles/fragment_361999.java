public class CalendarMap<V> {

    private TreeMap<Calendar, V> map = new TreeMap<Calendar, V>();

    public void put(Calendar d, V v){
        map.put(d, v);
    }

    public void query(Calendar d, int intervalUnit, int intervalValue){
         DateFormat df = new SimpleDateFormat("MMM dd, yyyy");
         DateFormat tf = new SimpleDateFormat("HH:mm");

        // snap closest prior unit
        d.set(intervalUnit, (d.get(intervalUnit) / intervalValue)* intervalValue);
        Calendar next = new GregorianCalendar();
        next.setTime(d.getTime());
        next.add(intervalUnit, intervalValue);

        Calendar lastHit = null; // last hit

        while(d.before(map.lastKey())){
            SortedMap<Calendar, V> hits = map.subMap(d, true, next, false);
            if(!hits.isEmpty()){
                if(lastHit != null){
                    System.out.println(df.format(lastHit.getTime()) + " " + tf.format(lastHit.getTime()) + " - " + 
                            df.format(d.getTime()) + " " + tf.format(d.getTime()) + ": N/A");
                    lastHit = null;
                }
                System.out.println(df.format(d.getTime()) + " " + tf.format(d.getTime()) + "-" + tf.format(next.getTime()) + ":");
                for(Entry<Calendar, V> entry : hits.entrySet()){
                    System.out.println("  " + tf.format(entry.getKey().getTime()) + " - " + entry.getValue());
                }
            }else if(lastHit == null){
                lastHit = new GregorianCalendar();
                lastHit.setTime(d.getTime());
            }
            d.add(intervalUnit, intervalValue);
            next.add(intervalUnit, intervalValue);
        }
    }

    public static void main(String[] args){
        CalendarMap<String> map = new CalendarMap<String>();
        map.put(new GregorianCalendar(2011, 1, 1, 13, 1), "Bob entered the room");
        map.put(new GregorianCalendar(2011, 1, 1, 12, 1), "Jerry entered the room");
        map.put(new GregorianCalendar(2011, 1, 1, 13, 31), "Sally entered the room");
        map.put(new GregorianCalendar(2011, 1, 1, 14, 1), "Dilbert entered the room");
        map.put(new GregorianCalendar(2011, 1, 2, 13, 1), "Bob entered the room");
        map.put(new GregorianCalendar(2011, 1, 3, 12, 1), "Jerry entered the room");
        map.put(new GregorianCalendar(2011, 1, 2, 13, 31), "Sally entered the room");
        map.put(new GregorianCalendar(2011, 1, 2, 13, 51), "Jorge entered the room");

        map.query(new GregorianCalendar(2011, 1, 1, 12, 9), Calendar.MINUTE, 15);
    }

}