public class ItemNode<T extends Amountable> implements Amountable {
    private T item;

    public ItemNode(T item) {
        this.item = item;
    }

    @Override
    public int getAmount() {
        return item.getAmount();
    }

    @Override
    public void setAmount(int amount) {
        item.setAmount(amount);
    }    

    public T getItem() {
        return item;
    }
}