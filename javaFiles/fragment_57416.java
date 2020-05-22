public class ItemListModel {
     public ArrayList<Result> results;

    @Override
    public String toString() {
        return "Response [results=" + results + "]";
    }

    public ArrayList<Result> getResults() {
        return results;
    }

}