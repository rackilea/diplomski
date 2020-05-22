import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TreeNode {
    TreeNode left;
    TreeNode right;
    String text;
}

public class SO {

    public static void main(final String... args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            TreeNode node = readNode(br);
        }
    }

    public static TreeNode readNode(BufferedReader reader) throws IOException {
        String text = reader.readLine();
        if (text.charAt(0) == '1') {
            TreeNode node = new TreeNode();
            node.text = text.substring(1);
            node.left = readNode(reader);
            node.right = readNode(reader);
            return node;
        } else {
            TreeNode node = new TreeNode();
            node.text = text;
            return node;
        }
    }
}