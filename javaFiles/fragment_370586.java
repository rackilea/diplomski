QImage pic = QImage(256, 256, QImage::Format_RGB888);
QRgb value;
int r,b,g;

for(int i = 0; i < height; i++) {
    for(int j = 0; j < width; j++) {
        // Access value of pixel at each location
        datum = store[i][j];
        //I get really confused what is going on here... you don't seem to be actually using `c` for the calculation?
        for(int c = 0; c < 3; c++) { //let's just pretend you set the ints r,b,g in here somewhere
            // Calculate colour at given pixel
            col = (255.0f * ((float)datum - (float)min) / ((float)(max - min)));
        }
        // Assign colour value to the pixel
        value = qRgb(r, g, b);
        pic.setPixel(i, j, value);
    }
}