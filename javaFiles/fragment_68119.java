import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.IOException;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import java.awt.EventQueue;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.TransferHandler;

import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTML;

public class HTMLCopier
extends TransferHandler {
    private static final long serialVersionUID = 1;

    private final Collection<DataFlavor> flavors;

    HTMLCopier() {
        Collection<DataFlavor> flavorList = new LinkedHashSet<>();
        Collections.addAll(flavorList,
            new DataFlavor(String.class, null),
            DataFlavor.stringFlavor);

        String[] mimeTypes = {
            "text/html", "text/plain"
        };
        Class<?>[] textClasses = {
            Reader.class, String.class, CharBuffer.class, char[].class
        };
        Class<?>[] byteClasses = {
            InputStream.class, ByteBuffer.class, byte[].class
        };
        String[] charsets = {
            Charset.defaultCharset().name(),
            StandardCharsets.UTF_8.name(),
            StandardCharsets.UTF_16.name(),
            StandardCharsets.UTF_16BE.name(),
            StandardCharsets.UTF_16LE.name(),
            StandardCharsets.ISO_8859_1.name(),
            "windows-1252",
            StandardCharsets.US_ASCII.name(),
        };

        try {
            flavorList.add(new DataFlavor(
                DataFlavor.javaJVMLocalObjectMimeType +
                "; class=" + String.class.getName()));

            for (String mimeType : mimeTypes) {
                for (Class<?> textClass : textClasses) {
                    flavorList.add(new DataFlavor(String.format(
                        "%s; class=\"%s\"",
                        mimeType, textClass.getName())));
                }
                for (String charset : charsets) {
                    for (Class<?> byteClass : byteClasses) {
                        flavorList.add(new DataFlavor(String.format(
                            "%s; charset=%s; class=\"%s\"",
                            mimeType, charset, byteClass.getName())));
                    }
                }
            }

            for (String mimeType : mimeTypes) {
                flavorList.add(new DataFlavor(String.format(
                    "%s; charset=unicode; class=\"%s\"",
                    mimeType, InputStream.class.getName())));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.flavors = Collections.unmodifiableCollection(flavorList);
    }

    @Override
    public int getSourceActions(JComponent component) {
        return COPY_OR_MOVE;
    }

    @Override
    public void exportToClipboard(JComponent component,
                                  Clipboard clipboard,
                                  int action) {
        JTextPane pane = (JTextPane) component;
        Document doc = pane.getDocument();

        int start = pane.getSelectionStart();
        int end = pane.getSelectionEnd();

        final String html;
        final String plainText;
        try {
            StringWriter writer = new StringWriter(end - start);
            pane.getEditorKit().write(writer, doc, start, end - start);
            html = writer.toString();

            StringBuilder plainTextBuilder = new StringBuilder();
            appendTextContent(doc.getDefaultRootElement(), start, end,
                plainTextBuilder);
            plainText = plainTextBuilder.toString();
        } catch (BadLocationException | IOException e) {
            throw new RuntimeException(e);
        }

        Transferable contents = new Transferable() {
            @Override
            public boolean isDataFlavorSupported(DataFlavor flavor) {
                return flavors.contains(flavor);
            }

            @Override
            public DataFlavor[] getTransferDataFlavors() {
                return flavors.toArray(new DataFlavor[0]);
            }

            @Override
            public Object getTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException,
                   IOException {

                String data;
                if (flavor.isMimeTypeEqual("text/html")) {
                    data = html;
                } else {
                    data = plainText;
                }

                Class<?> dataClass = flavor.getRepresentationClass();
                if (dataClass.equals(char[].class)) {
                    return data.toCharArray();
                }
                if (flavor.isRepresentationClassReader()) {
                    return new StringReader(data);
                }
                if (flavor.isRepresentationClassCharBuffer()) {
                    return CharBuffer.wrap(data);
                }
                if (flavor.isRepresentationClassByteBuffer()) {
                    String charset = flavor.getParameter("charset");
                    return Charset.forName(charset).encode(data);
                }
                if (flavor.isRepresentationClassInputStream()) {
                    String charset = flavor.getParameter("charset");
                    return new ByteArrayInputStream(
                        data.getBytes(charset));
                }
                if (dataClass.equals(byte[].class)) {
                    String charset = flavor.getParameter("charset");
                    return data.getBytes(charset);
                }
                return data;
            }
        };

        clipboard.setContents(contents, null);

        if (action == MOVE) {
            pane.replaceSelection("");
        }
    }

    private void appendTextContent(Element element,
                                   int textStart,
                                   int textEnd,
                                   StringBuilder content)
    throws BadLocationException {
        int start = element.getStartOffset();
        int end = element.getEndOffset();
        if (end < textStart || start >= textEnd) {
            return;
        }

        start = Math.max(start, textStart);
        end = Math.min(end, textEnd);

        AttributeSet attr = element.getAttributes();
        Object tag = attr.getAttribute(AttributeSet.NameAttribute);

        if (tag.equals(HTML.Tag.HEAD) ||
            tag.equals(HTML.Tag.TITLE) ||
            tag.equals(HTML.Tag.COMMENT) ||
            tag.equals(HTML.Tag.SCRIPT)) {

            return;
        }

        if (tag.equals(HTML.Tag.INPUT) ||
            tag.equals(HTML.Tag.TEXTAREA) ||
            tag.equals(HTML.Tag.SELECT)) {

            // Swing doesn't provide a way to read input values
            // dynamically (as far as I know;  I could be wrong).
            return;
        }

        if (tag.equals(HTML.Tag.IMG)) {
            Object altText = attr.getAttribute(HTML.Attribute.ALT);
            if (altText != null) {
                content.append(altText);
            }
            return;
        }

        if (tag.equals(HTML.Tag.CONTENT)) {
            content.append(
                element.getDocument().getText(start, end - start));
            return;
        }

        int count = element.getElementCount();
        for (int i = 0; i < count; i++) {
            appendTextContent(element.getElement(i), textStart, textEnd,
                content);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTextPane text = new JTextPane();
                text.setContentType("text/html");
                text.setEditable(false);
                text.setText("somewords <img src=\"file:///C:/filepath/fire.png\" text=\"[fire1]\" title=\"[fire2]\" alt=\"[fire3]\" style=\"width:11px;height:11px;\"> otherwords");

                text.setTransferHandler(new HTMLCopier());

                JFrame window = new JFrame("HTML Copier");
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.getContentPane().add(new JScrollPane(text));
                window.pack();
                window.setLocationByPlatform(true);
                window.setVisible(true);

                text.selectAll();
                text.copy();
            }
        });
    }
}