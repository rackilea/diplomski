public CustomSmall(Parcel in){
    Log.d(TAG,"CustomSmall(Parcel in)");
    mId = in.readInt();
    mName = in.readString();
    mDummy = in.readInt();
    mStringList = new ArrayList<>();
    in.readTypedList(mStringList,MyString.CREATOR);
}