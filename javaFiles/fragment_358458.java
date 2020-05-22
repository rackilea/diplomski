class HouseNumber implements Comparable<HouseNumber>{
        private Integer house;
        private Integer flat;

        private HouseNumber(String s) {
            String[] fields = s.split("-");
            house = Integer.valueOf(fields[0]);
            flat = Integer.valueOf(fields[1]);
        }

        @Override
        public int compareTo(HouseNumber o) {
            if (house.compareTo(o.house) == 0) {
                return flat.compareTo(o.flat);
            } 
            return house.compareTo(o.house);
        }

    }

    String[] input = {"9-11", "9-01", "10-02", "10-01", "2-09", "3-88", "9-03"};
    Map<HouseNumber, String> map = new TreeMap<HouseNumber, String>();
    for (String s : input) {
        map.put(new HouseNumber(s), s);
    }
    TreeSet<HouseNumber> set = new TreeSet<HouseNumber>(map.keySet());
    String[] output = new String[input.length];
    int i = 0;
    for (HouseNumber key : set) {
        output[i++] = map.get(key);
    }