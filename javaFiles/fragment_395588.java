public class AppCore extends Application {
    public UserEdbHelper userHelper;
    public ProductEdbHelper productHelper;

    // onCreate and such stuff...

    public SQLiteDatabase getUserDb() {
        if (null == userHelper) { userHelper = new UserEdbHelper(this); }
        return userHelper.getWritableDatabase();
    }

    public SQLiteDatabase getProductDb() {
        if (null == productHelper) { productHelper = new ProductEdbHelper(this); }
        return productHelper.getWritableDatabase();
    }

    // other code

}