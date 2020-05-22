@Entity
public class User {

    private List<String> itemList = new ArrayList<String>();

    @CollectionOfElements
    @JoinTable(name="TABLE_ITEM")
    private List<String> getItemList() {
        return this.itemList;
    }

}