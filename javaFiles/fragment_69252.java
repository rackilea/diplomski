public class Capac {

    public static void main(String[] args) {
        final String arr[] = { "Online Add-on 750 MB 2014", "Online Add-on 375 MB 2015", "Online Add-on 1.5 GB 2015",
                "Online Add-on 3 GB 2015", "Online Add-on 6 GB 2015", "Online Add-on 12 GB 2015" };

        final List<Capac> myList = new ArrayList<>();
        for (final String string : arr) {
            myList.add(new Capac(string));
        }
        System.out.println(myList);
        // sort
        Collections.sort(myList, new Comparator<Capac>() {

            @Override
            public int compare(Capac o1, Capac o2) {
                if (o1.unit == o2.unit) {
                    return Double.compare(o1.size, o2.size);
                } else {

                    return Integer.compare(o1.unit.ordinal(), o2.unit.ordinal());
                }

            }
        });
        System.out.println(myList);
    }

    private final double size;
    private final int year;
    private final Unit unit;
    private final String prefix;

    public Capac(String ss) {
        final String[] rr = ss.split(" ");
        prefix = rr[0] + " " + rr[1];
        size = Double.parseDouble(rr[2]);
        unit = Unit.valueOf(rr[3]);
        year = Integer.parseInt(rr[4]);
    }

    @Override
    public String toString() {
        return prefix + " " + size + " " + unit + " " + year;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
        long temp;
        temp = Double.doubleToLongBits(size);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((unit == null) ? 0 : unit.hashCode());
        result = prime * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Capac other = (Capac) obj;
        if (prefix == null) {
            if (other.prefix != null)
                return false;
        } else if (!prefix.equals(other.prefix))
            return false;
        if (Double.doubleToLongBits(size) != Double.doubleToLongBits(other.size))
            return false;
        if (unit != other.unit)
            return false;
        if (year != other.year)
            return false;
        return true;
    }

}

enum Unit {
    KB, MB, GB, TB
}