public class HouseSorter {

    enum Status {
        SOLD, AVAILABLE, CONTINGENT;
    }

    /**
     * Immutable house (if a house is sold or not does not change a house, use a
     * Map instead).
     */
    private static class House {
        private final String city;

        House(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "House in " + city;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!House.class.isAssignableFrom(obj.getClass())) {
                return false;
            }
            return this.city.equalsIgnoreCase(((House) obj).city);
        }

        @Override
        public int hashCode() {
            return city.hashCode();
        }
    }

    public static SortedSet<House> sortAlphabetically(Set<House> houses) {
        TreeSet<House> sortedHouses = new TreeSet<House>(
                new Comparator<House>() {
                    @Override
                    public int compare(House o1, House o2) {
                        return o1.getCity().compareTo(o2.getCity());
                    }
                });
        sortedHouses.addAll(houses);
        return sortedHouses;
    }

    public static SortedSet<House> sortByStatus(
            final Map<House, Status> houseStatusMap) {
        TreeSet<House> sortedHouses = new TreeSet<House>(
                new Comparator<House>() {
                    @Override
                    public int compare(House o1, House o2) {
                        int compareByStatus = houseStatusMap.get(o1).compareTo(
                                houseStatusMap.get(o2));
                        if (compareByStatus != 0) {
                            return compareByStatus;
                        }
                        // you need an additional compare, until none of the
                        // houses compare with result 0
                        // otherwise the houses would be equal and therefore
                        // removed from the set
                        return o1.getCity().compareTo(o2.getCity());
                    }
                });
        sortedHouses.addAll(houseStatusMap.keySet());
        return sortedHouses;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        final Map<House, Status> houseStatusMap = new HashMap<House, Status>();
        House house0 = new House("Beverwijk");
        houseStatusMap.put(house0, Status.SOLD);
        House house1 = new House("Opmeer");
        houseStatusMap.put(house1, Status.SOLD);
        House house2 = new House("Amstelveen");
        houseStatusMap.put(house2, Status.AVAILABLE);
        House house3 = new House("Haarlem");
        houseStatusMap.put(house3, Status.CONTINGENT);

        System.out.println(sortAlphabetically(houseStatusMap.keySet()));
        System.out.println(sortByStatus(houseStatusMap));
    }
}