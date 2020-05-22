package mehad.util;

import javax.swing.JLabel;

public class MessageUtil {
    public static void main(String[] args) {
        for (JLabel label : createMultiLabel("Albert Einstein\nWerner Heisenberg\nMax Planck"))
            System.out.println(label.getText() + " / " + label.getForeground());
        System.out.println();
        for (JLabel label : createMultiLabel("Albert Einstein, Werner Heisenberg, Max Planck"))
            System.out.println(label.getText() + " / " + label.getForeground());
    }

    public static JLabel[] createMultiLabel(String msg) {
        return msg.contains("\n")
            ? createMultiLabelBySlashN(msg)
            : createMultiLabelByPixel(msg);
    }

    private static JLabel[] createMultiLabelBySlashN(String msg) {
        String[] lines = msg.split("\n+");
        JLabel[] labels = new JLabel[lines.length];
        for (int i = 0; i < lines.length; i++)
            labels[i] = new JLabel(lines[i]);
        return labels;
    }

    private static JLabel[] createMultiLabelByPixel(String msg) {
        String[] words = msg.split("[, ]+");
        JLabel[] labels = new JLabel[words.length];
        for (int i = 0; i < words.length; i++)
            labels[i] = new JLabel(words[i]);
        return labels;
    }
}