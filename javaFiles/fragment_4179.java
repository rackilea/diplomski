public class TestFrame extends JFrame {

    public static void main(String[] args) {

        JEditorPane editorPane = new JEditorPane("text/html", "test <a href=\"http://example.com\">link to example.com</a>");
        editorPane.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                System.out.println("CLICK");
                if (e.getEventType().equals(HyperlinkEvent.EventType.ENTERED)) try {
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().browse(e.getURL().toURI());
                    }
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }
                catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });
        editorPane.setEditable(false); // otherwise ignores hyperlink events!

        JFrame frame = new JFrame("EditorPane Example");
        frame.add(editorPane);
        frame.setSize(300,200);
        frame.setVisible(true);
    } }