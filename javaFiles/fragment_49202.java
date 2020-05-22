//make these class scope
int currentTextSize = 0;
int[] textViewSizes = new int[] {10, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

public void TextBigger(View view) {
    if(currentTextSize < textViewSizes.length - 1)
        currentTextSize++;
    text_View.setTextSize(TypedValue.COMPLEX_UNIT_SP, textViewSizes[currentTextSize]);
}