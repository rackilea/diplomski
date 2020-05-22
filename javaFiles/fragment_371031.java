import java.awt.*;
import javax.swing.*;


public class WrapTest extends JFrame {

    public WrapTest() {
        super("test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel label = new JLabel("<html>Lorem <b>ipsum</b> dolor sit amet, consectetur adipiscing elit. "
                + "Aliquam non pellentesque enim. Donec nec nisl tortor."
                + " Curabitur rutrum molestie est eget varius. Nullam ut lacinia est."
                + " Phasellus hendrerit sollicitudin justo, vitae malesuada dolor vestibulum at."
                + " Integer pharetra purus sed ipsum pulvinar, et pretium odio volutpat. Donec vitae varius metus."
                + " Cras sagittis vulputate erat, at faucibus lectus faucibus id. Cras varius nunc eu felis tristique dapibus."
                + " Aenean enim eros, dapibus pellentesque nibh ut, efficitur malesuada sapien. Nullam imperdiet nunc velit,"
                + "sed laoreet massa mattis eget. Morbi id justo quis sapien aliquet bibendum sed at leo. In mi felis, consectetur"
                + " sed orci eget, tempus maximus turpis. Curabitur sed felis id nisl vehicula sollicitudin sed eget erat.Ut sagittis at nisi sed facilisis."
                + " Morbi vel felis ac diam molestie consequat. Sed nisl lectus, sollicitudin at neque in, "
                + "placerat aliquet nunc. Maecenas quis enim vitae nunc fermentum congue. Sed posuere quam a ultricies fringilla."
                + " Vivamus aliquam nunc lacus, vitae consectetur tortor consequat ut. Cras viverra mi sit amet magna auctor eleifend."
                + " Morbi in risus nisl. Praesent nunc dolor, lobortis nec ultricies aliquet, sollicitudin eu sapien. Fusce interdum ac leo non suscipit."
                + "Vivamus at viverra elit, ut vestibulum elit. Sed bibendum, lorem et ornare sagittis, erat nulla ultricies odio, quis iaculis lacus nisl "
                + "vel ligula. Sed iaculis elit eu felis consectetur dignissim. ");


        ScrollablePanel panel = new ScrollablePanel( new BorderLayout() );
        panel.setScrollableWidth( ScrollablePanel.ScrollableSizeHint.FIT );
        panel.add( label );

        JScrollPane sp = new JScrollPane(panel);
        add(sp, BorderLayout.CENTER);

        setLocationByPlatform(true);
        setSize(500, 200);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WrapTest().setVisible(true);
        });
    }
}