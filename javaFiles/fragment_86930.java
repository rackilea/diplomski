package dummy.lexico;

/*
 * About LLStringNode, see http://jcsites.juniata.edu/faculty/kruse/cs240/linkedlist1.htm
 * or http://www.cs.nyu.edu/courses/fall12/CSCI-GA.1133-001/programs/StringLogs/LLStringNode.txt
 * 
 */
public class Main {

    public static void main(String[] args) {
        LLStringNode log = new LLStringNode("toto");
        LLStringNode log2 = new LLStringNode("tata");
        log.setLink(log2);
        LLStringNode log3 = new LLStringNode("t");
        log2.setLink(log3);
        System.out.println(smallest(log));

    }

    public static String smallest(final LLStringNode log) {

        LLStringNode node = log;
        String smallString = log.getInfo();

        while (node.getLink() != null) {
            node = node.getLink();
            final String info = node.getInfo();
            if (info == null)
                throw new IllegalStateException("Node info should have been filled.");
            if (node.getInfo().compareTo(smallString) < 0) {
                smallString = node.getInfo();
            }

        }
        return smallString;

    }

}