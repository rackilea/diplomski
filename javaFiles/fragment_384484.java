public abstract class ItemList<ITEM_TYPE> {
    public abstract ItemState<ITEM_TYPE> getState();

    public abstract ITEM_TYPE getItem();
}

public abstract class ItemState<ITEM_TYPE> {
    public abstract ItemList<ITEM_TYPE> getItemList();

    public void doSomething() {
        ITEM_TYPE item = getItemList().getItem();
        System.out.println(item);
    }
}

public class StringList extends ItemList<String> {
    @Override
    public StringState getState() {
        return new StringState();
    }

    @Override
    public String getItem() {
        return "";
    }
}

public class StringState extends ItemState<String> {
    @Override
    public StringList getItemList() {
        return new StringList();
    }
}