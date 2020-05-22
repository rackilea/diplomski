import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class CardLayoutExample2 {

    public static void main(String[] args) {
        new CardLayoutExample2();
    }

    public CardLayoutExample2() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new WizardPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class WizardPane extends JPanel {

        private List<String> pages;
        private String currentPage;

        private JButton first;
        private JButton previous;
        private JButton next;
        private JButton last;

        private CardLayout cardLayout;
        private JPanel contentPane;

        public WizardPane() {
            setLayout(new BorderLayout());
            cardLayout = new CardLayout();
            pages = new ArrayList<>(3);

            contentPane = new JPanel(cardLayout);
            contentPane.setBorder(new EmptyBorder(4, 4, 4, 4));

            pages.add("Page01");
            pages.add("Page02");
            pages.add("Page03");

            contentPane.add(new FirstPage(), "Page01");
            contentPane.add(new SecondPage(), "Page02");
            contentPane.add(new ThirdPage(), "Page03");

            JPanel actionsPane = new JPanel(new GridBagLayout());
            actionsPane.setBorder(new EmptyBorder(4, 4, 4, 4));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            actionsPane.add((first = new JButton("<< First")), gbc);
            gbc.gridx++;
            gbc.weightx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            actionsPane.add((previous = new JButton("< Previous")), gbc);

            gbc.gridx++;
            gbc.anchor = GridBagConstraints.EAST;
            actionsPane.add((next = new JButton("Next >")), gbc);
            gbc.gridx++;
            gbc.weightx = 0;
            actionsPane.add((last = new JButton("Last >>")), gbc);

            add(contentPane);
            add(actionsPane, BorderLayout.SOUTH);

            NavigationHandler handler = new NavigationHandler();
            first.addActionListener(handler);
            previous.addActionListener(handler);
            next.addActionListener(handler);
            last.addActionListener(handler);

            gotoFirstPage();
        }

        protected void gotoFirstPage() {
            currentPage = pages.get(0);
            cardLayout.show(contentPane, currentPage);
        }

        protected void gotoPreviousPage() {
            int index = pages.indexOf(currentPage);
            index--;
            if (index >= 0) {
                currentPage = pages.get(index);
                cardLayout.show(contentPane, currentPage);
            }
        }

        protected void gotoNextPage() {
            int index = pages.indexOf(currentPage);
            index++;
            if (index < pages.size()) {
                currentPage = pages.get(index);
                cardLayout.show(contentPane, currentPage);
            }
        }

        protected void gotoLastPage() {
            currentPage = pages.get(pages.size() - 1);
            cardLayout.show(contentPane, currentPage);
        }

        protected class NavigationHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == first) {
                    gotoFirstPage();
                } else if (e.getSource() == previous) {
                    gotoPreviousPage();
                } else if (e.getSource() == next) {
                    gotoNextPage();
                } else if (e.getSource() == last) {
                    gotoLastPage();
                }
            }
        }

    }

    public class FirstPage extends JPanel {

        public FirstPage() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel("Page One");
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label);
        }

    }

    public class SecondPage extends JPanel {

        public SecondPage() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel("Page Two");
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label);
        }

    }

    public class ThirdPage extends JPanel {

        public ThirdPage() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel("Page Three");
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label);
        }

    }
}