public enum Test implements IsSerializable {
    FOOD("FOOD",getFoodItems()),//---Getting Error here.
    HOTEL("HOTEL",getHotels());//---Getting Error here
    private String name;
    private final List<String> categories;
    private Test(String name,List<String> categories) {
        this.name = name;
        this.categories=categories;
    }
    public List<String> getCategories() {
        return this.categories;
    }
    private static List<String> getFoodItems(){
        List<String> categories = new LinkedList<>();
        categories.add("Food item1");
        categories.add("Food item2");
        return categories;
    }
    private static List<String> getHotels(){
        List<String> categories = new ArrayList<>();
        categories.add("Hotel 1");
        categories.add("Hotel 2");
        return categories;
     }
}