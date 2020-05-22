public class Constants {

    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;

    @IntDef(value={PAGE_ONE, PAGE_TWO, PAGE_THREE})
    public @interface PageType {}

    private static final SparseArray<String> PAGE_TITLES = new SparseArray<>();
    private static final SparseArray<Integer> PAGE_IMAGES = new SparseArray<>();
    static {
        PAGE_TITLES.put(PAGE_ONE, "PAGE_ONE");
        PAGE_IMAGES.put(PAGE_ONE, R.drawable.page_one);

        PAGE_TITLES.put(PAGE_TWO, "PAGE_TWO");
        PAGE_IMAGES.put(PAGE_TWO, R.drawable.page_two);

        PAGE_TITLES.put(PAGE_THREE, "PAGE_THREE");
        PAGE_IMAGES.put(PAGE_THREE, R.drawable.page_three);
    }

    public static int getPageDrawable(@PageType int pageNumber){
        return PAGE_IMAGES.get(pageNumber);
    }

    public static String getPageTitle(@PageType int pageNumber){
        return PAGE_TITLES.get(pageNumber);
    }

    private Constants(){}
}