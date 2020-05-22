import java.util.Formatter;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.io.StreamTokenizer.*;


public class NodeToker {

   public static void main(String[] args) throws IOException  {
      final String fname = "/data/types.txt";
      InputStream stream = Class.class.getResourceAsStream(fname);

      if (stream == null) {
         System.err.println("Could not open stream " + fname);
      } else {
         NodeToker typeToker = new NodeToker();
         AllTypes allTypes = typeToker.parse(stream);

         try { stream.close(); }
         catch (IOException ex) { }

         Formatter fmtr = new Formatter(System.out);

         int groupCount = 0;
         for (NodeSet nodeSet : allTypes) {
            groupCount++;
            int nodeCount = 0;
            for (Node node : nodeSet) {
               fmtr.format("Set %s, Node %s: %s%n",
                       groupCount, ++nodeCount, node);
            }
         }
      }
   }

   public AllTypes parse(InputStream stream) throws IOException {
      Reader reader = new BufferedReader(new InputStreamReader(stream));

      StreamTokenizer tok = new StreamTokenizer(reader);
      setupToker(tok);

      AllTypes allTypes = new AllTypes();

      while (tok.nextToken() != TT_EOF) {
         String text = tok.sval == null ? "" : tok.sval;

         if (text.startsWith("type")) {
            // slurp newline
            tok.nextToken();
            handleNodeSet(tok, allTypes);
         }
      }

      return allTypes;
   }

   private void handleNodeSet(
           StreamTokenizer tok,
           AllTypes allTypes) throws IOException {
      while (tok.nextToken() != TT_EOF) {
         if (tok.ttype == TT_NUMBER) {
            final int numRows = (int) tok.nval;
            tok.nextToken();

            NodeSet nodeSet = allTypes.newNodeSet();

            for (int i = 0; i < numRows; i++) {
               Node node = nodeSet.newNode();
               handleNode(tok, node);
            }
         } else {
            // maybe beginning of next type?
            tok.pushBack();
            break;
         }
      }
   }

   private void handleNode(StreamTokenizer tok,
           Node node) throws IOException {
      while (!endOfRow(tok)) {
         if (tok.ttype == TT_NUMBER) {
            node.addNumber((int)tok.nval);
         } else if (tok.ttype == TT_WORD) {
            node.addName(tok.sval);
         }
      }
   }

   private void setupToker(StreamTokenizer tok) {
      tok.eolIsSignificant(true);
   }

   private boolean endOfRow(StreamTokenizer tok) throws IOException {
      return (tok.nextToken() == TT_EOL) || (tok.ttype == TT_EOF);
   }

   public static class AllTypes implements Iterable<NodeSet> {
      private List<NodeSet> typesList = new ArrayList<NodeSet>();

      public NodeSet newNodeSet() {
         NodeSet typeGroup = new NodeSet();
         typesList.add(typeGroup);
         return typeGroup;
      }

      public Iterator<NodeSet> iterator() {
         return Collections.unmodifiableCollection(typesList).iterator();
      }

   }

   public static class NodeSet implements Iterable<Node> {
      private List<Node> nodeList = new ArrayList<Node>();

      public Node newNode() {
         Node node = new Node();
         nodeList.add(node);
         return node;
      }

      public Iterator<Node> iterator() {
         return Collections.unmodifiableCollection(nodeList).iterator();
      }

   }

   public static class Node {
      private List<Integer> numbers = new ArrayList<Integer>();
      private List<String> names = new ArrayList<String>();

      public void addName(String name) {
         names.add(name);
      }

      public void addNumber(int number) {
         numbers.add(number);
      }

      @Override
      public String toString() {
         return "Node{" + "numbers=" + numbers + " names=" + names + '}';
      }
   }
}