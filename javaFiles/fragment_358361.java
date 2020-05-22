int wi = bImg.getWidth();
int he = bImg.getHeight();
for (int i = 0; i < wi; i++) {
    for (int j = 0; j < he; j++) {
        wr[i + j * wi] = ((i % 256) << 16) | ((i * j % 256) << 8) | (j % 256);
    }
}