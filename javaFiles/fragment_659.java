public class Main {
    private int[] pixelValues;

    public Main() {
        pixelValues = [99];
    }

    public void setPixelValue(int position, int value) {
        pixelValues[position] = value;
    }

    public static void main(String[] args) {
         Main main = new Main();
         new PixelAssign(main);
    }
}

public class PixelAssign {
    public PixelAssign(Main main, posX, posY) {
        main.setPixelValue(0, 98);
    }
}