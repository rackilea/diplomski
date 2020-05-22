public interface HszService {
    int getDefaultPage();
    int getDefaultPageSize();
    Response getUsers(int page, int pageSize);
    Response getItems(int page, int pageSize);
    Response getItems(ItemType type, int page, int pageSize);
}