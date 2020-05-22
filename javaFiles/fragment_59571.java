public class ParcelableListOfLists implements Parcelable {

    private ArrayList<ArrayList<imageHolder>> listOfLists;

    public ParcelableListOfLists(ArrayList<ArrayList<imageHolder>> listOfLists) {
        this.listOfLists = listOfLists;
    }

    public ArrayList<ArrayList<imageHolder>> getListOfLists() {
        return listOfLists;
    }

    // parcelable implementation here
}