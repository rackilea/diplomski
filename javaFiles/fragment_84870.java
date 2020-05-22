public class ComparatorsGroup {
                public static Comparator<Item> IdComparator = new Comparator<Item>() {
                  public int compare(Item item1, Item item2) {
                     return item1.getId().compareTo(item2.getId());
                  }
            };

            public static Comparator<Item> GenreComparator = new Comparator<Item>() {
                  public int compare(Item item1, Item item2) {
                     return item1.getGenre().compareTo(item2.getGenre());
                  }
            };
}