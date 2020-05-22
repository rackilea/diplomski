Resources resources = getResources();

float left = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 140, resources.getDisplayMetrics());

float top = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 140, resources.getDisplayMetrics());

canvas.drawBitmap(pasteImage, left, top, null);