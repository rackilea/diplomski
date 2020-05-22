import java.util.HashMap;
import java.util.Map;

/**
 *                              A<br>
 *                  /           |           \<br>
 *                  B           C           D<br>
 *              /       \           /   /       \   \<br>
 *              E       F           G   H       I   J<br>
 *                      |<br>
 *                      K<br>
 * 
 *
 */
public class SerializeDeserialize {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuilder newsb = new StringBuilder();

        // prepare TrieNode Tree
        TrieNodeSD root = buildTrienodeTree();

        // serialize tree into string
        serialize(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        System.out.println();

        // construct tree again from serialized string
        TrieNodeSD newRoot = deserialize(sb.toString().split(","), new int[] { 0 });

        // Verify : again serialize above de-serialized tree to match both
        // trees serialized format.
        serialize(newRoot, newsb);
        newsb.deleteCharAt(newsb.length() - 1);
        System.out.println(newsb.toString());
    }

    private static void serialize(TrieNodeSD node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.character + ",");
        if (node.characters != null && node.characters.size() > 0) {
            for (Character c : node.characters.keySet()) {
                serialize(node.characters.get(c), sb);
            }
        }
        sb.append("#,");
    }

    private static TrieNodeSD deserialize(String[] data, int[] t) {
        if (t[0] >= (data.length - 1) || data[t[0]].equals("#")) return null;
        TrieNodeSD node = new TrieNodeSD(data[t[0]].charAt(0));
        while (true) {
            t[0] = t[0] + 1;
            TrieNodeSD child = deserialize(data, t);
            if (child != null) node.characters.put(child.character, child);
            else break;
        }
        return node;
    }

    private static TrieNodeSD buildTrienodeTree() {
        TrieNodeSD root = new TrieNodeSD('A');

        root.characters.put('B', new TrieNodeSD('B'));
        root.characters.get('B').characters.put('E', new TrieNodeSD('E'));
        root.characters.get('B').characters.put('F', new TrieNodeSD('F'));
        root.characters.get('B').characters.get('F').characters.put('K', new TrieNodeSD('K'));

        root.characters.put('C', new TrieNodeSD('C'));

        root.characters.put('D', new TrieNodeSD('D'));
        root.characters.get('D').characters.put('G', new TrieNodeSD('G'));
        root.characters.get('D').characters.put('H', new TrieNodeSD('H'));
        root.characters.get('D').characters.put('I', new TrieNodeSD('I'));
        root.characters.get('D').characters.put('J', new TrieNodeSD('J'));

        return root;
    }
}

class TrieNodeSD {
    Map<Character, TrieNodeSD> characters;
    char character;

    public TrieNodeSD(char c) {
        this.characters = new HashMap<Character, TrieNodeSD>();
        this.character = c;
    }

    @Override
    public String toString() {
        return this.character + "";
    }
}