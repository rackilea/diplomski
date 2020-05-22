import javax.swing.*;

class HtmlUsingBase {

    public static void main(String[] args) {
        final String htmlContent =
            "<html>" +
            "<head>" +
            "<base href='http://www.gravatar.com/'>" +
            "</head>" +
            "<body>" +
            "<h1>Image path from BASE</h1>" +
            "<img src='avatar/a1ab0af4997654345d7a9" +
            "49877f8037e?s=128&d=identicon&r=PG'" +
            " width='128' height='128'>" +
            "</body>" +
            "</html>";
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JLabel label = new JLabel(htmlContent);
                JOptionPane.showMessageDialog(null, label);
            }
        });
    }
}