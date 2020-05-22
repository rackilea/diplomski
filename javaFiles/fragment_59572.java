@Override
public void writeToParcel(Parcel dest, int flags) {
    if (listOfLists != null) {
        dest.writeInt(listOfLists.size());

        for (ArrayList<imageHolder> list : listOfLists) {
            dest.writeTypedList(list);
        }
    } else {
        dest.writeInt(-1);
    }
}