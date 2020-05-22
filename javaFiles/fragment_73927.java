int w = _imageBitmap.getWidth();
int h = _imageBitmap.getHeight();

for (int i = originalImageWidth - 1; i >= w/4; i -= w/2)
    for (int j = originalImageHeight  - 1; j >= h/4; j -= h/2)
    {
        //it may be a bit strange to check (i - w/2, j - h/2, i, j) instead of ( i, j, i + w/2, j + h/2)
        // but it's simpler considering your integral image implementation.
        if (imageIntegral.total(i - w/2, j - h/2, i, j) == 0)
        {
            //check if there is enough space around
        }
    }