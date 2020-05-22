private int getMatColor(String typeColor)
{
    int returnColor = Color.BLACK;
    int arrayId = getResources().getIdentifier("mdcolor_" + typeColor, "array", getApplicationContext().getPackageName());

    if (arrayId != 0)
    {
        TypedArray colors = getResources().obtainTypedArray(arrayId);
        int index = (int) (Math.random() * colors.length());
        returnColor = colors.getColor(index, Color.BLACK);
        colors.recycle();
    }
    return returnColor;
}