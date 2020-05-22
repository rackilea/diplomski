float[] colorMatrix_Negative = { -1.0f, 0, 0, 0, 255, // red
            0, -1.0f, 0, 0, 255, // green
            0, 0, -1.0f, 0, 255, // blue
            0, 0, 0, 1.0f, 0 // alpha
    };
private final Paint mPaintNegative = new Paint();
private final ColorFilter colorFilter_Negative = new ColorMatrixColorFilter(colorMatrix_Negative);