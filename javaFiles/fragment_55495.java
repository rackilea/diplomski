[...]
public Rectangle() {
    this(true, 0, 0, 0, 0);
}
public Rectangle(int width, int height) {  
    this(false, 0, 0, width, height);
}
public Rectangle(int x, int y, int width, int height) {
    this(true, x, y, width, height);
}
private Rectangle(boolean flag, int x, int y, int width, int height) {
    this.flag = flag;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    init();
}
[...]