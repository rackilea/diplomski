public class MyClass {
    private int rowCount;

    public void doStuff() {
        Object session = new Object();

        try {
            session.getClass();  // represents session.getTransaction();

            // begin of different part
            String s = session.toString();
            System.out.println(s);
            this.setRowCount(5);
            // end of different part

            session.getClass();  // represents commit
        } catch (Exception e) {
            e.printStacktrace();
        } finally {
            System.out.println("Do some cleanup");
        }
    }

    public void setRowCount(int count) {
        rowCount = count;
    }
}