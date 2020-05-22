public ParcelableListOfLists(Parcel in) {
    int size = in.readInt();

    if (size != -1) {
        this.listOfLists = new ArrayList<>(size);

        for (int i = 0; i < size; ++i) {
            ArrayList<imageHolder> list = in.createTypedArrayList(imageHolder.CREATOR);
            listOfLists.add(list);
        }
    } else {
        this.listOfLists = null;
    }
}