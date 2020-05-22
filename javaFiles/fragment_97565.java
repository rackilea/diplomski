public static ArrayList<CategoryObject> getCategories(Context context) {
    final ArrayList<CategoryObject> categoryObjects = new ArrayList<>();
    final Resources resources = context.getResources();

    CategoryObject categoryObject = new CategoryObject();
    categoryObject.setCategoryTitle(resources.getString(R.string.psi));
    categoryObject.setItem1(resources.getString(R.string.psi1));
    categoryObject.setItem2(resources.getString(R.string.psi2));
    categoryObject.setItem3(resources.getString(R.string.psi3));
    categoryObject.setItem4(resources.getString(R.string.psi4));

    categoryObjects.add(categoryObject);

    return categoryObjects;
}