import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class CodeParser {

    @Test
    public void should_get_connection() throws SQLException {
        final String correctCode = "for(int i = 0; i < 3; i++)\n" +
                "    for(int j = 0; j < 5; j++) {\n" +
                "        final JButton btn = btn1[i][j];\n" +
                "        btn1[i][j].addActionListener(\n" +
                "            new ActionListener() {\n" +
                "                public void actionPerformed(ActionEvent e) {\n" +
                "                    btn.setBackground(Color.RED);\n" +
                "                }\n" +
                "            }\n" +
                "        );\n" +
                "    }\n";

        final String html = "<p>Add listeners in loop:</p>\n" +
                "\n" +
                "<pre><code>for(int i = 0; i &lt; 3; i++)\n" +
                "    for(int j = 0; j &lt; 5; j++) {\n" +
                "        final JButton btn = btn1[i][j];\n" +
                "        btn1[i][j].addActionListener(\n" +
                "            new ActionListener() {\n" +
                "                public void actionPerformed(ActionEvent e) {\n" +
                "                    btn.setBackground(Color.RED);\n" +
                "                }\n" +
                "            }\n" +
                "        );\n" +
                "    }\n" +
                "</code></pre>\n" +
                "\n" +
                "<p>You added listener only to the first button.</p>\n";

        final String code = CodeFilter.geCodeFromBody(html);
        Assert.assertEquals(correctCode, code);

    }
}
