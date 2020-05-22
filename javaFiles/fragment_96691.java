public class BitMap {

public BitMap(int width, int height){
    this.width = width;
    this.height = height;

    this.data = new int[width * height];
}

public BitMap(int[] data, int width, int height) {
    this.data = data;
    this.width = width;
    this.height = height;
}

private int[] data;
private int width, height;

public int getWidth(){
    return width;
}

public int getHeight(){
    return height;
}

public int getValue(int x, int y){
    return data[x + y * width];
}

public BitMap fillWithValues(int value){
    for(int i = 0; i < data.length; i++){
        data[i] = value;
    }
    return this;
}

public void setValue(int xScr, int yScr, int value) {
    data[xScr + yScr * width] = value;
}

public int[] getValues() {
    return data;
}

public BitMap subData(int xPos, int yPos, int w, int h) {
    BitMap bitmap = new BitMap(w, h);
    for(int y = 0; y < h; y++){
        for(int x = 0; x < w; x++){
            bitmap.setValue(x, y, this.getValue(x + xPos, y + yPos));
        }
    }
    return bitmap;
}