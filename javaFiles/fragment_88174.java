public class Item {
    private int id;
    private int parentId;

    public Item(int id, int parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    public int getId() { return id; }
    public int getParentId() { return parentId; }
}

public class NumberedItem {
    private Item item;
    private int childCount;
    private String number;

    public NumberedItem(Item item, String number) {
        this.item = item;
        this.childCount = 0;
        this.number = number;
    }

    public Item getItem() { return item; }
    public String getNumber() { return number; }

    /* package */ int incrementChildCount() {
        return ++childCount;
    }
}

public NumberedItemIterator implements Iterable<NumberedItem> {
    private Iterator<Item> items;
    private Stack<NumberedItem> numberStack;

    public NumberedItemIterator(Iterable<Item> itemsIterable) {
        items = itemsIterable.iterator();
        numberStack = new Stack<NumberedItem>();
        numberStack.push(new NumberedItem(null, null));
    }

    public boolean hasNext() {
        return items.hasNext();
    }

    public NumberedItem next() {
        Item current = items.next();
        int parentId = current.getParentId();

        NumberedItem parent = null;
        while (!numberStack.empty()) {
            NumberedItem candidate = numberStack.peek();
            if (candidate.getItem().getId() == parentId) {
                parent = candidate;
                break;
            }
            numberStack.pop();
        }

        if (parent == null) throw new RuntimeException("Inconsistent ordering");

        String number = Integer.toString(parent.incrementChildCount());
        if (parent.getNumber() != null) {
            number = parent.getNumber() + "." + number;
        }

        NumberedItem result = new NumberedItem(current, number);

        numberStack.push(result);

        return result;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}