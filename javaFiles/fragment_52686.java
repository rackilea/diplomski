private void initializationTest() {
    DragEvent event = null;
    /* maybe sth like that
    Parcel source = Parcel.obtain();
    source.writeInt(1234);
    event  = DragEvent.CREATOR.createFromParcel(source);
    */
    onDrag(theTargetView, event);
}