public class ReceiptItem {
    private static final int TITLE_WIDTH = 30;
    private static final String DETAIL_FORMAT="%-" + TITLE_WIDTH + "s : %6s%n";

    private String title;
    private BigDecimal totalPrice;

    public ReceiptItem(String title, BigDecimal totalPrice) {
        setTitle(title);
        setTotalPrice(totalPrice);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String toFormattedString() {
        return String.format(DETAIL_FORMAT, getTitle(),
                getTotalPrice().toPlainString());
    }
}


public class Receipt {
    private static final String RECEIPT_HEADER_FORMAT = "Receipt number #%s%n";
    private static int LAST_RECEIPT_NUMBER = 0;
    private int receiptNumber;
    private List<ReceiptItem> items= new ArrayList<>();

    public Receipt() {
        super();
        setReceiptNumber(++LAST_RECEIPT_NUMBER);
    }

    public Receipt(int receiptNumber) {
        this();
        setReceiptNumber(LAST_RECEIPT_NUMBER=receiptNumber);
    }

    public void addItem(ReceiptItem item) {
        items.add(item);
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }
    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }
    public List<ReceiptItem> getItems() {
        return items;
    }
    public void setItems(List<ReceiptItem> items) {
        this.items = items;
    }
    public String toFormattedString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(RECEIPT_HEADER_FORMAT, getReceiptNumber()));
        for (ReceiptItem item:getItems()) {
            builder.append(item.toFormattedString());
        }
        return builder.toString();
    }
}


Receipt receipt = new Receipt();
receipt.addItem(new ReceiptItem("Beef Burgers", new BigDecimal("5.00")));
receipt.addItem(new ReceiptItem("Cheese Burgers", new BigDecimal("5.00")));
receipt.addItem(new ReceiptItem("Fish and Chips", new BigDecimal("6.00")));
receipt.addItem(new ReceiptItem("French Fries", new BigDecimal("4.00")));
receipt.addItem(new ReceiptItem("Steak", new BigDecimal("10.00")));
receipt.addItem(new ReceiptItem("Sprite Drinks", new BigDecimal("1.00")));
receipt.addItem(new ReceiptItem("Soda Drinks", new BigDecimal("0.40")));
receipt.addItem(new ReceiptItem("Fuzetea Drinks", new BigDecimal("0.70")));
recieptText.setText(reciept.toFormattedString());