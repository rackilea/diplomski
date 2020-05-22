public class BookRecommendationsContentPanel extends JPanel {

    public BookRecommendationsContentPanel(JLabel lblStatus) {
        super();

        ...

        this.setBorder(new EmptyBorder(20, 20, 10, 20));
    }

    public void AddBook(Book book) {

        JPanel pnlBook = new JPanel();
        ...
        this.add(pnlBook);
    }
}