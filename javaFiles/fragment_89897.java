import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private AccordionLayout layout;

        public TestPane() {
            layout = new AccordionLayout();
            setLayout(layout);

            AccordionListener listener = new AccordionListener() {
                @Override
                public void accordionSelected(Component comp) {
                    layout.setExpanded(comp);
                    revalidate();
                    repaint();
                }
            };

            Color colors[] = {Color.RED, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW};
            String titles[] = {"Red", "Blue", "Cyan", "Green", "Magenta", "Orange", "Pink", "Yellow"};
            for (int index = 0; index < colors.length; index++) {
                AccordionPanel panel = new AccordionPanel(titles[index], new ContentPane(colors[index]));
                panel.setAccordionListener(listener);
                add(panel);
            }
        }

    }

    public class ContentPane extends JPanel {

        public ContentPane(Color background) {
            setBackground(background);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

    }

    public interface AccordionListener {

        public void accordionSelected(Component comp);

    }

    public class AccordionPanel extends JPanel {

        private JLabel title;
        private JPanel header;
        private Component content;

        private AccordionListener accordionListener;

        public AccordionPanel() {
            setLayout(new BorderLayout());

            title = new JLabel("Title");

            header = new JPanel(new FlowLayout(FlowLayout.LEADING));
            header.setBackground(Color.GRAY);
            header.setBorder(new LineBorder(Color.BLACK));
            header.add(title);
            add(header, BorderLayout.NORTH);

            header.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    AccordionListener listener = getAccordionListener();
                    if (listener != null) {
                        listener.accordionSelected(AccordionPanel.this);
                    }
                }
            });
        }

        public AccordionPanel(String title) {
            this();
            setTitle(title);
        }

        public AccordionPanel(String title, Component content) {
            this(title);
            setContentPane(content);
        }

        public void setAccordionListener(AccordionListener accordionListener) {
            this.accordionListener = accordionListener;
        }

        public AccordionListener getAccordionListener() {
            return accordionListener;
        }

        public void setTitle(String text) {
            title.setText(text);
            revalidate();
        }

        public String getText() {
            return title.getText();
        }

        public void setContentPane(Component content) {
            if (this.content != null) {
                remove(this.content);
            }

            this.content = content;
            if (this.content != null) {
                add(this.content);
            }
            revalidate();
        }

        public Component getContent() {
            return content;
        }

        @Override
        public Dimension getMinimumSize() {
            return header.getPreferredSize();
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = content != null ? content.getPreferredSize() : super.getPreferredSize();
            Dimension min = getMinimumSize();
            size.width = Math.max(min.width, size.width);
            size.height += min.height;
            return size;
        }

    }

    public class AccordionLayout implements LayoutManager {

        // This "could" be controled by constraints, but that would assume
        // that more then one component could be expanded at a time
        private Component expanded;

        public void setExpanded(Component expanded) {
            this.expanded = expanded;
        }

        public Component getExpanded() {
            return expanded;
        }

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            Dimension size = minimumLayoutSize(parent);
            if (expanded != null) {
                size.height -= expanded.getMinimumSize().height;
                size.height += expanded.getPreferredSize().height;
            }

            return size;
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            int height = 0;
            int width = 0;
            for (Component comp : parent.getComponents()) {
                width = Math.max(width, comp.getPreferredSize().width);
                height += comp.getMinimumSize().height;
            }
            return new Dimension(width, height);
        }

        @Override
        public void layoutContainer(Container parent) {

            Insets insets = parent.getInsets();
            int availableHeight = parent.getHeight() - (insets.top + insets.bottom);
            int x = insets.left;
            int y = insets.top;

            int maxSize = 0;
            Dimension minSize = minimumLayoutSize(parent);
            if (expanded != null) {
                minSize.height -= expanded.getMinimumSize().height;
                // Try an honour the preferred size the expanded component...
                maxSize = Math.max(expanded.getPreferredSize().height, availableHeight - minSize.height);
            }

            int width = parent.getWidth() - (insets.left + insets.right);
            for (Component comp : parent.getComponents()) {
                if (expanded != comp) {
                    comp.setSize(width, comp.getMinimumSize().height);
                } else {
                    comp.setSize(width, maxSize);
                }
                comp.setLocation(x, y);
                y += comp.getHeight();
            }

        }

    }

}