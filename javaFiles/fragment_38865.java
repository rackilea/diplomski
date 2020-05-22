public static void main(String[] argv) {
    QuadExample quadExample = new QuadExample();
    try {
        quadExample.start();
    } catch (Exception e) {
        Display.destroy(); // destroying the display here now
        e.printStackTrace();
    }
}