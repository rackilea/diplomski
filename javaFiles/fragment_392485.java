public class MainProgram implements OrderView{

    //remove statics here
    private JPanel centerPanel = new JPanel();
    private CardLayout contentCardsLayout = new CardLayout();

    private BasicDataPage basicPage;

    public MainProgram() {
        //other codes
        OverviewPage overviewPage = new OverviewPage();
        basicPage = new BasicDataPage();

        centerPanel.setLayout(contentCardsLayout);

        overviewPage.setName("overviewPage");
        basicDataPage.setName("basicDataPage");

        centerPanel.add(overviewPage, "overviewPage");
        centerPanel.add(basicPage, "basicDataPage");
        //oher codes
    }

    @Override
    public void loadOrder(OrderObject order) {
        basicPage.recieveOrderObject(orderObject);

        contentCardsLayout.show(centerPanel, "basicDataPage");
    }
}

public interface OrderView {

    public void loadOrder(OrderObject order);
}

public class OverviewPage {

    OrderView orderView;

    public OverviewPage(OrderView orderView) {
        this.orderView = orderView;
    }

    //in ActionPerformed
    if (mouseEvent.getClickCount() == 2 && row != -1) {
        String workNumberOfOrderObject = (String) table.getValueAt(row, 0);
        OrderObject orderObject = GetOrderObject.getOrderObjectFromDatabase(workNumberOfOrderObject);
        orderView.loadOrder(orderObject);
        workNumberPanel.recieveOrderObject(orderObject);
        workNumberPanel.setTxtWorkNumber(workNumberOfOrderObject);
    }
}