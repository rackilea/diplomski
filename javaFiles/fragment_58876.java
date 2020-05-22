import java.util.ArrayList;
import java.util.List;

public class Main {

    static Node input = new Node();

    public static class Node {
        String numbers;
        List<Node> childs;
    }

    static class Input {
        String data;
        int pos;

        Input(String data, int pos) {
            this.data = data;
            this.pos = pos;
        }
    }

    public static void main(String[] args) {
        String data = "0.5, 0.0 [\n" +
                " 1.5, -1.0 [\n" +
                "  inputs\n" +
                " ]\n" +
                " ;\n" +
                " 0.5, 1.0 [\n" +
                "  inputs\n" +
                " ]\n" +
                "]";

        Node node = parseNode(new Input(data, 0));
    }

    private static Node parseNode(Input input) {
        StringBuffer stringBuffer = new StringBuffer();

        // eat chars until '[' or ']' or ';' or end of string
        boolean completed = false;
        char ch = input.data.charAt(input.pos);

        while (!completed && input.pos < input.data.length()) {
            ch = input.data.charAt(input.pos);
            switch (ch) {
                case '[':
                case ']':
                case ';':
                    completed = true;
                    break;
                default:
                    input.pos++;
                    stringBuffer.append(ch);
            }
        }

        String numbers = stringBuffer.toString().trim();

        if ( numbers.equalsIgnoreCase("inputs") ) {
            return Main.input;
        }

        Node thisNode = new Node();

        thisNode.numbers = numbers;
        thisNode.childs = new ArrayList<Node>();

        if ( ch == '[' ) { // we have childs
            do {
                input.pos++;
                thisNode.childs.add(parseNode(input));

                ch = input.data.charAt(input.pos);
                while ( ch != ';' && ch != ']' ) {
                    input.pos++;
                    ch = input.data.charAt(input.pos);
                }
            } while (ch == ';');

            if ( ch == ']' ) {
                input.pos++;
            }
        }

        return thisNode;
    }
}