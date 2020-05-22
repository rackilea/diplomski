private static List<Log> getInitialList() {
    List<Log> initialList = new ArrayList<>();
    initialList.add(new Log("Title 6", "ID 6", LocalDateTime.of(2017,  1, 18, 23, 15, 12), "A"));
    initialList.add(new Log("Title 3", "ID 3", LocalDateTime.of(2005,  4, 20, 16, 10, 10), "B"));
    initialList.add(new Log("Title 1", "ID 1", LocalDateTime.of(2010, 10, 25,  3,  5,  2), "C"));
    initialList.add(new Log("Title 2", "ID 2", LocalDateTime.of(2018,  2, 18, 21, 13, 32), "D"));
    initialList.add(new Log("Title 3", "ID 3", LocalDateTime.of(2016,  5, 16, 15, 23, 15), "E"));
    initialList.add(new Log("Title 1", "ID 1", LocalDateTime.of(2012,  2,  8, 14, 46, 28), "F"));
    initialList.add(new Log("Title 6", "ID 6", LocalDateTime.of(1996,  1, 28, 22, 26, 34), "G"));
    initialList.add(new Log("Title 3", "ID 3", LocalDateTime.of(2007,  4, 15,  2,  5, 55), "H"));
    initialList.add(new Log("Title 6", "ID 3", LocalDateTime.of(2018,  1, 15, 20, 15, 10), "I"));
   return initialList;
}