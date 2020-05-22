Matrix matrix = new Matrix();
RectF from = new RectF(0, 0, bm.getIntrinsicWidth(), bm.getIntrinsicHeight());
RectF to = new RectF(view.getWidth() * 0.9, view.getHeight() * 0.7, view.getWidth(), view.getHeight());
matrix.setRectToRect(from, to, Matrix.ScaleToFit.FILL);

view.setScaleType(ScaleType.MATRIX);
view.setImageMatrix(matrix);