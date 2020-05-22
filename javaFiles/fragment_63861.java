public DataBaseHelper(Parcel source, Context context, String name,
                      SQLiteDatabase.CursorFactory factory, int version) {
    // NOTE: You've got to pass in an appropriate Context; I'm sure it would not work
    // to try to include the original Activity in the Parcel! That means that your 
    // constructor **must** include the Context as one of its arguments. Conceivably,
    // the name, factory, and version could be taken from the Parcel rather than being
    // passed in the constructor arguments. Again, I ask: Is it worth the hassle?
    super(context, name, factory, version);

    // First, restore any relevant `SQLiteOpenHelper` state...
           //...
    // Now restore any relevant DataBaseHelper state...
           //...
}