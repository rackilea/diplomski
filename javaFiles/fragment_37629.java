// get all the SthLog with their sth
List<SthLog> list = 
    session.createQuery("select s from SthLog s inner join fetch s.sth").list();
// index them by their sth
ListMultimap<Sth, SthLog> result = ArrayListMultimap.create();
for (SthLog sthLog : list) {
    result.put(sthLog.getSth(), sthLog);
}