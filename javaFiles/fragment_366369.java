public int half() {
    return side/2;
}
public int left() {
    return center_x - half();
}
public int top() {
    return center_y - half();
}
public int right() {
    return center_x + half();
}
public int bottom() {
    return center_y + half();
}

public void draw(BufferedImage image) {

    int left = left();
    int top = top();
    int right = right();
    int bottom = bottom();

    for (int i = left; i < right; i++){
        for (int j = top; j < bottom; j++){
            image.setRGB(i, j, color);
        }
    }
} //End Square