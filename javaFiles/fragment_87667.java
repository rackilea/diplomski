// Parameters to ImageNormalization
float mean = 160;
float variance = 150;

int width = fastBitmap.getWidth();
int height = fastBitmap.getHeight();

float globalMean = Mean(fastBitmap);
float globalVariance = Variance(fastBitmap, globalMean);

for (int i = 0; i < height; i++) {
    for (int j = 0; j < width; j++) {

        int g = fastBitmap.getGray(i, j);
        float common = (float)Math.sqrt((variance * (float)Math.pow(g - globalMean, 2)) / globalVariance);
        int n = 0;
        if (g > globalMean){
            n = (int)(mean + common);
        }
        else{
            n = (int)(mean - common);
        }

        n = n > 255 ? 255 : n;
        n = n < 0 ? 0 : n;

        fastBitmap.setGray(i, j, n);
    }
}

private float Mean(FastBitmap fb){
    int height = fb.getHeight();
    int width = fb.getWidth();

    float mean = 0;
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            mean += fastBitmap.getGray(i, j);
        }
    }
    return mean / (width * height);
}

private float Variance(FastBitmap fb, float mean){
    int height = fb.getHeight();
    int width = fb.getWidth();

    float sum = 0;
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            sum += Math.pow(fastBitmap.getGray(i, j) - mean, 2);
        }
    }
    return sum / (float)((width * height) - 1);
}