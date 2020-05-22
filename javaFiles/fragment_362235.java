public interface HszService {
    void setPageProperties(int page, int pageSize);
    Response getUsers();
    Response getItems();
    Response getItems(ItemType type);
}