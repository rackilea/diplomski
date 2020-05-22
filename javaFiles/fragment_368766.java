//you need a matrix
Matrix matrix = new Matrix();

// set the scale
matrix.postScale(scaleWidth, scaleHeight);

// rotate the Bitmap
matrix.postRotate(90);

// then apply it
img.setImageMatrix(matrix);