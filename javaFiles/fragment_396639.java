interface PixelLogic {
    public int doOperation();
}

class BlurLogic implements PixelLogic {
    @Override
    public int doOperation() {
        return // some calculated value
    }
}

class SomeClass {

    public void runPixelOperation(PixelLogic logic) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                pixels[j][i] = logic.doOperation();
            }
        }
    }

}