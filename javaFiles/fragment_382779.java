class DatedObject {
        final String name; final int year;
        DatedObject(String name, int year) {
            this.name = name; this.year = year;
        }
        @Override public String toString() {
            return String.format("%s (%d)", name, year);
        }
    }
    List<DatedObject> masterList = Arrays.asList(
        new DatedObject("A", 2010),
        new DatedObject("B", 2009),
        new DatedObject("C", 2006),
        new DatedObject("D", 2010),
        new DatedObject("E", 2009),     
        new DatedObject("F", 2011)          
    );
    NavigableMap<Integer,List<DatedObject>> objectsByYear =
        new TreeMap<Integer,List<DatedObject>>();
    for (DatedObject obj : masterList) {
        List<DatedObject> yearList = objectsByYear.get(obj.year);
        if (yearList == null) {
            objectsByYear.put(obj.year, yearList = new ArrayList<DatedObject>());
        }
        yearList.add(obj);          
    }
    System.out.println(objectsByYear);
    // prints "{2006=[C (2006)], 2009=[B (2009), E (2009)],
    //          2010=[A (2010), D (2010)], 2011=[F (2011)]}"
    System.out.println(objectsByYear.get(2011));
    // prints "[F (2011)]"
    System.out.println(objectsByYear.subMap(2007, true, 2010, true));
    // prints "{2009=[B (2009), E (2009)], 2010=[A (2010), D (2010)]}"