final List<String> l = Arrays.asList(
        "id1 0.44 0.5 #0.13800099498102508",
        "id2 0.44 0.8 #0.22080159196964014",
        "id3 0.44 0.5 #0.15771581712401433",
        "id4 0.44 0.8 #0.22080159196964014",
        "id5 0.11 0.5 #0.04353560295326771",
        "id6 0.11 0.2 #0.017414241181307084");

Collections.sort(l, new Comparator<String>() {
    @Override
    public int compare(final String o1, final String o2) {
        return o1.substring(o1.indexOf("#") + 1).compareTo(o2.substring(o2.indexOf("#") + 1));
    }
}.reversed());

l.forEach(System.out::println);