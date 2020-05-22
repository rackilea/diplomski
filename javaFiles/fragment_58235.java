class ControlMouse {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            Thread.sleep(1000);
            robot.mouseMove(0, 0);
            Thread.sleep(1000);
            robot.mouseMove(100, 100);
        } catch (Exception e) {
            System.out.println("e = " + e.toString());
        } catch (Error e) {
            System.out.println("e = " + e.toString());
        }
    }
}