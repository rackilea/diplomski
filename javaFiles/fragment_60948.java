class WebService {

 // key = timeWindow (for ex:10:00 or 10:30 or 11:00), value = <List of entries for that timewindow>
 ConcurrentHashMap<String, List<Entry>> map= new ConcurrentHashMap<String, List<Entry>>();

    //have setup a timer to call this every 10 mins.
    void updateArrayList(){
     // populate the map for the next time window with the corresponding entries. So that its ready before we start using it. Also, clean up the expired entries for older time windows.

    }

    void readFromList(){
      list = map.get(currentTimeWindow)
      for(Entry e: list) {
       //do some processing
      }
    }

}