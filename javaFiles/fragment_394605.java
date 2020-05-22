import javax.swing.*;

class HeightOfFixedWidthText {

    public static void show(String s) {
        JLabel l = new JLabel(s);
        l.setSize(l.getPreferredSize());
        JOptionPane.showMessageDialog(null, l);
        System.out.println(l.getSize());
    }

    public static void main(String[] srgs) {
        String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eu nulla urna. Donec sit amet risus nisl, a porta enim. Quisque luctus, ligula eu scelerisque gravida, tellus quam vestibulum urna, ut aliquet sapien purus sed erat. Pellentesque consequat vehicula magna, eu aliquam magna interdum porttitor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed sollicitudin sapien non leo tempus lobortis. Morbi semper auctor ipsum, a semper quam elementum a. Aliquam eget sem metus.";
        String html1 = "<html><body " +
            "style='font-family: Serif; font-style: italic; font-size: 20px; padding: 0px; margin: 0px;" +
            " width: ";
        String html2 = "px'>";
        String html3 = "</body></html>";

        show(html1+"200"+html2+s+html3);
        show(html1+"300"+html2+s+html3);
    }
}