public void writeToParcel(Parcel out, int arg1) {
    out.writeInt(mObjList.length);
    out.writeTypedArray(mObjList, arg1);
}

private void readFromParcel(Parcel in) {
    int size = in.readInt();
    mObjList = in.readTypedArray(new MyClass[size], MyClass.CREATOR);
}