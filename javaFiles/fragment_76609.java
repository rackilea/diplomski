import javax.swing.*;

class FixedWidthLabel {

    public static void main(String[] args) {
        Runnable r = () -> {
            String html = "<html><body width='%1s'><h1>Label Width</h1>"
                + "<p>Many Swing components support HTML 3.2 &amp; "
                + "(simple) CSS.  By setting a body width we can cause "
                + "the component to find the natural height needed to "
                + "display the component.<br><br>"
                + "<p>The body width in this text is set to %1s pixels.";
            // change to alter the width 
            int w = 175;

            JOptionPane.showMessageDialog(null, String.format(html, w, w));
        };
        SwingUtilities.invokeLater(r);
    }
}