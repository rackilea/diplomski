private DictionaryNode<K,V> curNode = rNode;

public K getKey(V value) {

    if (curNode != null) {
         int c = ((Comparable<V>)curNode.value).compareTo(value);

         if (c == 0) {

              K key = curNode.key;

              curNode = rNode; // reset curNode
              return key;
         }
         else if (c < 0 && curNode.lChild != null) {
              curNode = curNode.lChild;
              return getKey(value);
         }
         else if (curNode.rChild != null) {
              curNode = curNode.rChild;
              return getKey(value);
         }
    }
    curNode = rNode; // reset curNode
    return null;