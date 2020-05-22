public class SupplementsItem {
    private int itemImage;
    private String item;
    private String category;
    private long expiryDate;

    public SupplementsItem(int itemImage, String item, String category, long expiryDate) {
        this.itemImage = itemImage;
        this.item = item;
        this.category = category;
        this.expiryDate = expiryDate;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(long expiryDate) {
        this.expiryDate = expiryDate;
    }

    //    This will sort your list ascending by category
    public static class CategoryComparatorUp implements Comparator<SupplementsItem> {
        @Override
        public int compare(SupplementsItem o1, SupplementsItem o2) {
            return o1.getCategory().compareToIgnoreCase(o2.getCategory());
        }
    }

    //    This will sort your list descending by category
    public static class CategoryComparatorDown implements Comparator<SupplementsItem> {
        @Override
        public int compare(SupplementsItem o1, SupplementsItem o2) {
            return o2.getCategory().compareToIgnoreCase(o1.getCategory());
        }
    }

    //    This will sort your list ascending by expiration date
    public static class ExpiryComparatorUp implements Comparator<SupplementsItem> {
        @Override
        public int compare(SupplementsItem o1, SupplementsItem o2) {
            return Long.compare(o1.getExpiryDate(), o2.getExpiryDate());
        }
    }

    //    This will sort your list descending by expiration date
    public static class ExpiryComparatorDown implements Comparator<SupplementsItem> {
        @Override
        public int compare(SupplementsItem o1, SupplementsItem o2) {
            return Long.compare(o2.getExpiryDate(), o1.getExpiryDate());
        }
    }
}