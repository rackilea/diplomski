public class Testtree {
public static void main(String[] args) {
    TradeNode nd1 = new TradeNode("A", 100);
    TradeNode nd2 = new TradeNode("B", 10);
    TradeNode nd3 = new TradeNode("B", 1000);
    Map<String, Integer> map = new HashMap<String, Integer>();
    addTreeNode(map, nd1);
    addTreeNode(map, nd2);
    addTreeNode(map, nd3);
    System.out.println(map);
}

private static void addTreeNode(Map<String, Integer> map, TradeNode node) {

    Integer integer = map.get(node.getCstm());
    if (integer == null) {
        map.put(node.getCstm(), node.getMon());
    } else {
        map.remove(node.getCstm());
        map.put(node.getCstm(), integer.intValue() + node.getMon());
    }

}
}