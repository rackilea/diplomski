public class TitleAndPlace{
    private final String title;
    private final String place;

    TitleAndPlace(String title, String place) {
        this.title = title;
        this.place = place;
    }

    public String getTitle() { return title; }

    public String getPlace() { return place; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        else if (o instanceof TitleAndPlace) {
            TitleAndPlace that = (TitleAndPlace) o;
            return Objects.equals(title, that.title)
                && Objects.equals(place, that.place);
        } else return false;
    }

    @Override public int hashCode() {
        return Objects.hash(title, place);
    }
}

Map<Integer, TitleAndPlace> map = new TreeMap<>();
map.put(1, new TitleAndPlace("T1", "P1"));
map.put(2, new TitleAndPlace("T2", "P2"));

for(Map.Entry<Integer, TitleAndPlace> entry : map.entrySet()){
  System.out.println("ID : " + entry.getKey() + " Title : " + entry.getValue().getTitle() + ", Place: " + entry.getValue().getPlace());
}