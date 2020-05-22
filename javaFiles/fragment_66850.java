public class TextAreaDemo extends JFrame {

    private JScrollPane jScrollPane;
    private JTextArea jTextArea ;
    private static final String FILE_PATH="/Users/user/IdeaProjects/StackOverflowIssues/file.txt";

 public TextAreaDemo() {

        try {
            jTextArea = new JTextArea(24, 31);

            jTextArea.read(new BufferedReader(new FileReader(FILE_PATH)), null);

        } catch (Exception e){

            e.printStackTrace();
        }

        jScrollPane = new JScrollPane(this.jTextArea);
        this.add(this.jScrollPane);
        this.setVisible(true);
        this.setSize(400, 200);
    }
    public static void main(String[] args) {
        TextAreaDemo textAreaDemo = new TextAreaDemo();
    }