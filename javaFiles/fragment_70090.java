norm = image of the same size of sobelX and sobelY;

for (int x = 0; x < horizontal dimension of the image; ++x) {
    for (int y = 0; y < vertical dimension of the image; ++y) {
        xPixel = sobelX.pixelAt(x,y);
        yPixel = sobelY.pixelAt(x,y);
        norm.pixelAt(x,y) = Math.hypot(xPixel, yPixel);
    }
}

return norm;