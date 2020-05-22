public void init(Context context, AttributeSet attrs, int defStyle) {
    if(attrs != null){
        int[] declareStyleableArray = IdHelper.getResourceDeclareStyleableIntArray(context, "ShaderImageView");
        if (declareStyleableArray != null && declareStyleableArray.length > 0) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, declareStyleableArray, defStyle, 0);
            square = typedArray.getBoolean(8, square);
            borderColor = typedArray.getColor(2, borderColor);
            borderWidth = typedArray.getDimensionPixelSize(4, borderWidth);
            borderAlpha = typedArray.getFloat(1, borderAlpha);
            typedArray.recycle();
        }

    }