public static void processA(int val) throws NullPointerException, IllegalStateException {
    try {
        System.out.println("1");
        processB(val);
    } catch (ArithmeticException e) {
        System.out.println("11");
    } catch (NullPointerException e) {
        System.out.println("12");
    } catch (IllegalStateException e) {
        System.out.println("13");
    }
    System.out.println("3");
}