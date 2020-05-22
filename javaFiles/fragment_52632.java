public class BasePaginatedResponse {

    private int item_count;
    private int items_per_page;
    private int offset;

    public BasePaginatedResponse(
            int item_count, int items_per_page, int offset) {
        this.item_count = item_count;
        this.items_per_page = items_per_page;
        this.offset = offset;
    }

}