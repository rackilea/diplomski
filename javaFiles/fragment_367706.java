public class FontHelper {

    private static final Map<String, Typeface> TYPEFACES = new HashMap<>();

    public static Typeface get(Context context,String fontFileName){
        Typeface typeface = TYPEFACES.get(fontFileName);
        if(typeface == null){
            typeface = Typeface.createFromAsset(context.getResources().getAssets(), fontFileName);
            TYPEFACES.put(fontFileName, typeface);
        }
        return typeface;
    }
}