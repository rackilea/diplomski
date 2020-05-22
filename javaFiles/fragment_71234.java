import java.util.ArrayList;
import java.util.Arrays;

public class So_47736214 {

  static String[][] testData = {
    {"1,2,3,4,5,#,6,#,#,7,8", "4,5,6"},                 // Does not contain
    {"1,2,3,4,5,#,6,#,#,7,8", "1,2,3,4,5,#,6,#,#,7,8"}, // Are equal 
    {"1,2,3,4,5,#,6,#,#,7,8", "2,4,5"},         // Contains in the left subtree   
    {"1,2,3,4,5,#,6,#,#,7,8", "3,#,6,#,7"},     // Contains in the right subtree 
    {"7,8,9", "10,11,12"},                      // Have nothing in common       
  };


  static class TreeItem {
    int value; TreeItem left; TreeItem right;
    TreeItem(int v) { this.value = v; }
  }

  static TreeItem tree1, tree2; // To hold the two trees to be compared

  /** Converts a string to a tree */
  private static TreeItem deserialize(String s) { 
    // First, prepare the layers of the tree as AttayLists containing items with values
    String[] ss = s.split(","); if (ss.length < 2) return null; // a separate string for each item 
    int pos = 0, len = 1;                       // Start position of the next layer and its length
    ArrayList<ArrayList<TreeItem>> layers = new ArrayList<>(); // A structure to hold the tree layers
    while (pos < ss.length) {
      String[] layerStrings = Arrays.copyOfRange(ss, pos, pos + len); // Strings for the next layer 
      ArrayList<TreeItem> layerItems = new ArrayList<>();             // Container for the layer's items  
      for (int i = 0; i < layerStrings.length; i++) 
        layerItems.add( ( layerStrings[i] == null || layerStrings[i].equals("#") ) ? 
          null : new TreeItem(Integer.parseInt(layerStrings[i])));    // Fill with items or nulls 
      layers.add(layerItems);
      pos += len; len *= 2;       // Start pos and lengths of the next layer
    }
    // Now the 2-d array of items is built. Establish links between an item and its subtrees 
    ArrayList<TreeItem> prevLayer = layers.get(0);  
    for (int i = 1; i < layers.size(); i++) { // Start from 1 -- skip layer 0  
      ArrayList<TreeItem> layer = layers.get(i);
      for (int j = 0; j < prevLayer.size(); j++ ) {
        TreeItem prevLayerItem = prevLayer.get(j);
        if (prevLayerItem != null) {
          prevLayerItem.left = layer.get(j * 2);      // left subtree is a next layer's item 
          prevLayerItem.right = layer.get(j * 2 + 1); // right subtree
        }
      };
      prevLayer = layer;
    }
    return layers.get(0).get(0); // The tree is ready. It's the root
  }

  private static void deserialize(String s1, String s2) {
    tree1 = deserialize(s1); 
    tree2 = deserialize(s2); 
  }

  static int levelCount;

  /** Puts the item into the appropriate position in the list of the layers 
   * and recursively processes the item's subtrees */  
  private static void insertItem(TreeItem item, ArrayList<TreeItem[]> layerList, int idx, int level) {
    TreeItem[] levelItems;
    if (layerList.size() < level + 1)  // Needs to create a new array for the level
      layerList.add(levelItems = new TreeItem[1 << level]); // size of the array = pow(2, level)  
    else                            
      levelItems = layerList.get(level);
    levelItems[idx] = item;
    idx *= 2; level++;
    if (item.left != null)
      insertItem(item.left, layerList, idx, level);
    if (item.right != null)
      insertItem(item.right, layerList, idx+ 1, level);
  }

  /** Writes the values from the list of layers into a string */ 
  private static String arraysToString(ArrayList<TreeItem[]> layerList) {
    StringBuilder sb = new StringBuilder();
    int strLen = 0;  
    for (TreeItem[] layer: layerList) 
      for (int i = 0; i < layer.length; i++) 
        if (layer[i] != null) {
          sb.append(layer[i].value + ",");
          strLen = sb.length();
        } else 
          sb.append("#,");
    return sb.length() == 0? "" : sb.substring(0, strLen - 1);
  }

  /** Converts a tree into a string */
  private static String serialize(TreeItem tree) {
    ArrayList<TreeItem[]> items = new ArrayList<>();
    levelCount = 0;
    insertItem(tree, items, 0, 0);
    return arraysToString(items); 
  }

  /** Converts a pair of trees into strings and look for substrings */  
  private static void test1(TreeItem t1, TreeItem t2) {
    System.out.println("Test1:");
    String s1 = serialize(t1), s2 = serialize(t2);
    String result = s1.contains(s2)? "contains" : "doesn't contain"; 
    System.out.format("  '%s' %s '%s'\n", s1, result, s2);
  }

  /** Checks if the trees are equal */
  private static boolean areEqual(TreeItem t1, TreeItem t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false; 
    return (areEqual(t1.left, t2.left) && areEqual(t1.right, t2.right)); 
  }

  /** Checks if t2 is a subtree of t1 */  
  private static boolean contains(TreeItem t1, TreeItem t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null) return false; 
    if (t2 == null) return true; 
    if ( t1.value == t2.value 
          && areEqual(t1.left, t2.left)
          && areEqual(t1.left, t2.left)) 
      return true;
    return (contains(t1.left, t2) || contains(t1.right, t2));
  }

  /** Checks if t1 is a subtree of t1, and shows the result */ 
  private static void test2(TreeItem t1, TreeItem t2) {
    System.out.println("Test2:");
    String s1 = serialize(t1), s2 = serialize(t2);
    String result = (contains(t1, t2)? "contains" : "doesn't contain"); 
    System.out.format("  '%s' %s '%s'\n", s1, result, s2);
  }

  public static void main(String[] args) {
    // runs the two tests through the test dataset
    for (int i = 0; i < testData.length; i++) {
      deserialize(testData[i][0], testData[i][1]); // converts strings into trees  
      test1(tree1, tree2);      // looks if t1 is a subtree of t1, using string representations  
      test2(tree1, tree2);      // looks if t1 is a subtree of t1, directly with trees
      System.out.println("");
    }
  }

}