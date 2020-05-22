package me.nrubin29.jterminal;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;

public class JTerminal extends JFrame {

    private JTextPane area = new JTextPane();
    private JTextField input = new JTextField("Input");

    private SimpleAttributeSet inputSAS = new SimpleAttributeSet(), output = new SimpleAttributeSet(), error = new SimpleAttributeSet();

    public JTerminal() throws IOException {
        super("JTerminal");

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        StyleConstants.setForeground(inputSAS, Color.GREEN);
        StyleConstants.setBackground(inputSAS, Color.BLACK);

        StyleConstants.setForeground(output, Color.WHITE);
        StyleConstants.setBackground(output, Color.BLACK);

        StyleConstants.setForeground(error, Color.RED);
        StyleConstants.setBackground(error, Color.BLACK);

        final ProcessBuilder builder = new ProcessBuilder("/bin/bash");

        input.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        String command = input.getText();
                        if (command.equals("")) return;

                        setTitle("JTerminal (" + command.split(" ")[0] + ")");

                        input.setText("");
                        input.setEditable(false);

                        write(inputSAS, command);

                                Process bash = builder.start();
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bash.getOutputStream());
                        outputStreamWriter.write(command);
                        outputStreamWriter.close();

                        bash.waitFor();

                        writeStream(bash.getErrorStream(), error);
                        writeStream(bash.getInputStream(), output);

                        input.setEditable(true);
                        setTitle("JTerminal");

                    } catch (Exception ex) { error(ex); }
                }
            }

            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {}
        });

        area.setBackground(Color.black);
        area.setCaretColor(Color.green);
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        area.setEditable(false);

        JScrollPane pane = new JScrollPane(area);
        pane.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        pane.setPreferredSize(new Dimension(640, 460));

        input.setBackground(Color.black);
        input.setForeground(Color.green);
        input.setCaretColor(Color.green);
        input.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        input.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        add(pane);
        add(input);

        Dimension DIM = new Dimension(640, 480);
        setPreferredSize(DIM);
        setSize(DIM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        pack();
        setVisible(true);

        input.requestFocus();
    }

    public static void main(String[] args) throws IOException {
        new JTerminal();
    }

    private void write(SimpleAttributeSet attributeSet, String... lines) {
        try {
            area.getStyledDocument().insertString(area.getStyledDocument().getLength(), "\n", attributeSet);
            for (String line : lines) {
                area.getStyledDocument().insertString(area.getStyledDocument().getLength(), line + "\n", attributeSet);
            }
        }
        catch (Exception e) { error(e); }
    }

    private void error(Exception e) {
        write(error, "An error has occured: " + e.getLocalizedMessage());
        e.printStackTrace(); //TODO: temp.
    }

    private void writeStream(InputStream s, SimpleAttributeSet color) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(s));

            ArrayList<String> strs = new ArrayList<String>();

            while(reader.ready()) strs.add(reader.readLine());

            if (strs.size() > 0) write(color, strs.toArray(new String[strs.size()]));
        }
        catch (Exception e) { error(e); }
    }
}