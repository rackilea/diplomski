import javax.swing.*;

class TestHtmlIndent {

    public static void main(String[] args) {
        String raw =
            "<html><head></head><body><div>" +
            "<a href=\"http://a.b\" style=\"font-size: 20px\">akamaitechnologies.com</a>" +
            "<a href=\"http://a.b\" style=\"font-size: 17px\">amazonaws.com</a>" +
            "<a href=\"http://a.b\" style=\"font-size: 18px\">cotendo.net</a>" +
            "<a href=\"http://a.b\" style=\"font-size: 24px\">facebook.com</a>" +
            "<a href=\"http://a.b\" style=\"font-size: 17px\">google.ch</a>" +
            "<a href=\"http://a.b\" style=\"font-size: 25px\">heise.de</a>" +
            "<a href=\"http://a.b\" style=\"font-size: 16px\">ip-plus.net</a>" +
            "<a href=\"http://a.b\" style=\"font-size: 21px\">ligatus.com</a>" +
            "</div></body></html>";
        String style =
            "<style type='text/css'>" +
            "body {width: 600px;}" +
            ".cloudLink {text-decoration: none; color: #0174DF; " +
            "font-family: helvetica, arial, sans-serif;}" +
            "</style>";
        raw = raw.replace("<head></head>", "<head>" +  style + "</head>");
        String space4 = "&nbsp;&nbsp;&nbsp;&nbsp";
        String space20 = space4 + space4 + space4 + space4 + space4;
        final String processed1 = raw.replace(
            "<a ", space20 + "<a class='cloudLink' ");

        Runnable r = new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, processed1);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}