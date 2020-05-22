public class Editor2 {

    private JTextPane editor;
    private DefaultStyledDocument doc;
    private JComboBox<String> fontSizeComboBox;
    private boolean caretControlFlag;
    private static final int DEFAULT_FONT_SIZE = 18;

    public static void main(String [] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Editor2().createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        editor = new JTextPane();
        editor.setMargin(new Insets(5, 5, 5, 5));
        editor.addCaretListener(new MyCaretListener());     
        JScrollPane editorScrollPane = new JScrollPane(editor);
        doc = new DefaultStyledDocument();
        initDocAttrs();
        editor.setDocument(doc);

        final String [] fontSizes = {"Font Size", "16", "18", 
            "20", "24", "28", "30", "34", "40", "50"};
        fontSizeComboBox = new JComboBox<String>(fontSizes);
        fontSizeComboBox.setEditable(false);
        fontSizeComboBox.addItemListener(new FontSizeItemListener());
        JFrame frame = new JFrame("Text Editor");
        frame.add(fontSizeComboBox, BorderLayout.NORTH);
        frame.add(editorScrollPane, BorderLayout.CENTER);
        frame.add(editorScrollPane);
        frame.setSize(800, 400);
        frame.setLocation(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        editor.requestFocusInWindow();
    }

    private void initDocAttrs() {
        Style style = doc.addStyle("my_doc_style", null);
        StyleConstants.setFontSize(style, 18);
        StyleConstants.setFontFamily(style, "SansSerif");
        doc.setParagraphAttributes(0, doc.getLength(), style, true);
    }

    private class FontSizeItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if ((e.getStateChange() != ItemEvent.SELECTED) ||
                    (fontSizeComboBox.getSelectedIndex() == 0)) {
                return;
            }
            String fontSizeStr = (String) e.getItem();
            int newFontSize = 0;
            try {
                newFontSize = Integer.parseInt(fontSizeStr);
            }
            catch (NumberFormatException ex) {
                return;
            }
            if (caretControlFlag) {
                caretControlFlag = false;
                return;
            }
            setFontAttrs(newFontSize);
            editor.requestFocusInWindow();
        }

        private void setFontAttrs(int newFontSize) {
            SimpleAttributeSet attrs = new SimpleAttributeSet();
            Style docStyle = doc.getStyle("my_doc_style");  
            int size = StyleConstants.getFontSize(docStyle);
            StyleConstants.setFontSize(attrs, newFontSize);
            String attrName = "mysize" + Integer.toString(newFontSize);
            attrs.addAttribute(attrName, attrName);

            int startPos = editor.getSelectionStart();
            String selectedText = editor.getSelectedText();
            if (selectedText == null || selectedText.trim().isEmpty()) {
                return;
            }
            int length = selectedText.length(); 
            doc.setCharacterAttributes(startPos, length, attrs, false);     
            editor.setDocument(doc);
        }
    }


    private class MyCaretListener implements CaretListener {
        @Override
        public void caretUpdate(CaretEvent e) {
            caretControlFlag = true;
            int dot = e.getDot();
            Element ele = doc.getCharacterElement(dot);
            AttributeSet attrs = ele.getAttributes();
            String fontSizeStr = "18";
            for (Enumeration en = attrs.getAttributeNames(); en.hasMoreElements();) {
                String attrName = en.nextElement().toString();
                if (attrName.contains("mysize")) {
                    fontSizeStr = attrName.substring(6);
                }
            }
            fontSizeComboBox.setSelectedItem(fontSizeStr);
            caretControlFlag = false;
        }
    }
}