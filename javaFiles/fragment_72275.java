public class ObjAbcTest {

    public static List<ObjAbc> populateList() {
            // same as yours
    }

    public static void main(final String[] args) {
        final List<ObjAbc> list = populateList();
        final Map<Integer, Integer> sums = new HashMap<Integer, Integer>();

        // compute sums
        for (final ObjAbc obj: list) {
            // this if can be simplified with ? operator
            if (sums.containsKey(obj.getCode())) {
                sums.put(obj.getCode(), sums.get(obj.getCode()) + obj.getValue());
            } else {
                sums.put(obj.getCode(), obj.getValue());
            }
        }

        // populates newList
        final List<ObjAbc> newList = new ArrayList<ObjAbc>();
        for (final Map.Entry<Integer, Integer> e : sums.entrySet()) {
            newList.add(new ObjAbc(e.getKey(), e.getValue()));
        }

        // TODO: sort?

        // outputs
        for (final ObjAbc n : newList) 
            System.out.println(n.toString());
        }
}