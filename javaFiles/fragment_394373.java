import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CardLayoutExample {

    public static void main(String[] args) {
        new CardLayoutExample();
    }

    public CardLayoutExample() {
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
                frame.add(new Wizard());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public interface NavigationController {

        public void nextPage();

        public void previousPage();

        public void lastPage();

        public void firstPage();

    }

    public interface Page {

        public NavigationController getNavigationController();

        public JComponent getView();
        public String getName();

    }

    public class Wizard extends JPanel implements NavigationController {

        private List<Page> pages;
        private Page currentPage;

        private CardLayout cardLayout;

        public Wizard() {
            cardLayout = new CardLayout();
            pages = new ArrayList<>(25);
            setLayout(cardLayout);
            pages.add(new FirstPage("Page01", this));
            pages.add(new SecondPage("Page02", this));
            pages.add(new ThirdPage("Page03", this));

            for (Page page : pages) {
                add(page.getView(), page.getName());
            }

            firstPage();
        }

        @Override
        public void nextPage() {
            int index = pages.indexOf(currentPage);
            index++;
            if (index < pages.size()) {
                cardLayout.next(this);
                currentPage = pages.get(index);
            }
        }

        @Override
        public void previousPage() {
            int index = pages.indexOf(currentPage);
            index--;
            if (index >= 0) {
                cardLayout.previous(this);
                currentPage = pages.get(index);
            }
        }

        @Override
        public void lastPage() {
            Page page = pages.get(pages.size() - 1);
            showPage(page);
        }

        @Override
        public void firstPage() {
            Page page = pages.get(0);
            showPage(page);
        }

        protected void showPage(Page page) {
            cardLayout.show(this, page.getName());
            currentPage = page;
        }

    }

    public abstract class AbstractPage extends JPanel implements Page, ActionListener {

        private NavigationController navigationController;
        private JPanel buttons;
        private String name;

        public AbstractPage(String name, NavigationController navigationController) {
            this.name = name;
            this.navigationController = navigationController;
            setLayout(new BorderLayout());
            buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            add(buttons, BorderLayout.SOUTH);
        }

        protected void insertButton(JButton button) {
            button.addActionListener(this);
            buttons.add(button);
        }

        @Override
        public NavigationController getNavigationController() {
            return navigationController;
        }

        @Override
        public JComponent getView() {
            return this;
        }

        @Override
        public String getName() {
            return super.getName(); 
        }

    }

    public class FirstPage extends AbstractPage implements Page {

        private JButton next = new JButton("Next >");

        public FirstPage(String name, NavigationController controller) {
            super(name, controller);
            JLabel label = new JLabel("First page");
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label);
            insertButton(next);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == next) {
                getNavigationController().nextPage();
            }
        }

    }

    public class SecondPage extends AbstractPage implements Page {

        private JButton next = new JButton("Next >");
        private JButton previous = new JButton("< Previous");

        public SecondPage(String name, NavigationController controller) {
            super(name, controller);
            JLabel label = new JLabel("Second page");
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label);
            insertButton(previous);
            insertButton(next);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == next) {
                getNavigationController().nextPage();
            } else if (e.getSource() == previous) {
                getNavigationController().previousPage();
            }
        }

    }

    public class ThirdPage extends AbstractPage implements Page {

        private JButton previous = new JButton("< Previous");

        public ThirdPage(String name, NavigationController controller) {
            super(name, controller);
            JLabel label = new JLabel("Third page");
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label);
            insertButton(previous);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == previous) {
                getNavigationController().previousPage();
            }
        }

    }
}