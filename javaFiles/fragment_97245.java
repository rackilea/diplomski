public class XMLComparator implements Comparator<String> {
    private Map<String,Integer> order;

    public XMLComparator(Map<String,Integer> desiredOrder) {
        order = desiredOrder;
    }

    public void compare(String s1, String s2) {
        return order.get(s1) - order.get(s2);
    }

}