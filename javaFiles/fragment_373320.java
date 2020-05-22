public class MultiPages extends JPanel implements ActionListener {

    MultiPages() {
        super(new BorderLayout());
        add(leftButton, BorderLayout.WEST);
        add(pages, BorderLayout.CENTER);
        add(rightButton, BorderLayout.EAST);
        leftButton.addActionListener(this);
        rightButton.addActionListener(this);
        animation.setInitialDelay(10);
        animation.setRepeats(false);
    }

    public void addPage(JComponent page) {
        page.setLocation(0, 0);
        pages.add(page);
        pages.setComponentZOrder(page, pages.getComponentCount() - 1);
        SwingUtilities.invokeLater(new Runnable() {
            @Override public void run() { doLayout(); }});
    }

    @Override
    public void doLayout() {
        Dimension size = getParent().getSize();
        size.width -= leftButton.getWidth() + rightButton.getWidth();
        pages.setSize(size);
        for (Component page : pages.getComponents()) {
            page.setSize(size);
        }
        super.doLayout();
    }

    private void scrollLeft() {
        direction = true;
        Component next = pages.getComponents()[pages.getComponentCount() - 1];
        pages.setComponentZOrder(next, 1);
        animation.start();
        leftButton.setEnabled(false);
        rightButton.setEnabled(false);
    }

    private void scrollRight() {
        direction = false;
        animation.start();
        leftButton.setEnabled(false);
        rightButton.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == leftButton) {
            scrollLeft();
        } else if (src == rightButton) {
            scrollRight();
        } else if (src == animation) {
            Component onTop = pages.getComponents()[0];
            onTop.setLocation(onTop.getX() + (direction ? +4 : -4), 0);
            if (Math.abs(onTop.getX()) < onTop.getWidth()) {
                animation.start();
            } else {
                if (direction) {
                    pages.setComponentZOrder(onTop, 1);
                } else {
                    pages.setComponentZOrder(onTop, pages.getComponentCount() - 1);
                }
                onTop.setLocation(0, 0);
                leftButton.setEnabled(true);
                rightButton.setEnabled(true);
            }
        }
    }
    private final JPanel pages = new JPanel(null);
    private final JButton leftButton = new JButton("<<");
    private final JButton rightButton = new JButton(">>");
    private final Timer animation = new Timer(0, this);
    private boolean direction;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Multi pages demo App");

                frame.setLayout(new BorderLayout());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                MultiPages multiPage = new MultiPages();
                multiPage.setPreferredSize(new Dimension(250, 100));

                JPanel page;
                page = new JPanel();
                page.setBackground(Color.CYAN);
                page.setLayout(new BorderLayout());
                page.add(new JLabel("First page", SwingConstants.CENTER), BorderLayout.CENTER);
                multiPage.addPage(page);
                page = new JPanel();
                page.setBackground(Color.YELLOW);
                page.setLayout(new BorderLayout());
                page.add(new JLabel("Second page", SwingConstants.CENTER), BorderLayout.CENTER);
                multiPage.addPage(page);
                page = new JPanel();
                page.setBackground(Color.GREEN);
                page.setLayout(new BorderLayout());
                page.add(new JLabel("Third page", SwingConstants.CENTER), BorderLayout.CENTER);
                multiPage.addPage(page);
                page = new JPanel();
                page.setBackground(Color.RED);
                page.setLayout(new BorderLayout());
                page.add(new JLabel("Fourth page", SwingConstants.CENTER), BorderLayout.CENTER);
                multiPage.addPage(page);

                frame.add(multiPage, BorderLayout.CENTER);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}