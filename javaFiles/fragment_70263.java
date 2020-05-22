package java.util;

import java.util.TreeMap.Entry;

public class TreeMapHax {

    static <K,V> List<Entry<K, V>> getLeafEntries(TreeMap<K, V> map) {      
        Entry<K, V> root = map.getFirstEntry();
        while( root.parent != null ) root = root.parent;

        List<Entry<K,V>> l = new LinkedList<Entry<K,V>>();
        visitInOrderLeaves(root, l);
        return l;
    }

    static <K,V> void visitInOrderLeaves(Entry<K, V> node, List<Entry<K, V>> accum) {       
        if( node.left != null ) visitInOrderLeaves(node.left, accum);       
        if( node.left == null && node.right == null ) accum.add(node);      
        if( node.right != null ) visitInOrderLeaves(node.right, accum);
    }

    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();

        for( int i = 0; i < 10; i++ )
            map.put(Integer.toString(i), i);

        System.out.println(getLeafEntries(map));
    }

}