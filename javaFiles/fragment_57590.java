import java.util.Date;
    import java.util.LinkedList;
    import java.util.ArrayList;
    import java.util.List;

    public class Prob {

        public static void main(String[] args) {

            long lStartTime = new Date().getTime();
            System.out.println("lStartTime:: " + lStartTime);
            List<Integer> integerList = new LinkedList<Integer>();
            for (int i = 0; i < 5000; i++) {
                integerList.add(0, i);
            }
            for (int i = 0; i < 100000; i++) {
                integerList.add(1000, i);
            }

            long lEndTime = new Date().getTime();
            System.out.println("lEndTime:: " + lEndTime);

            long difference = lEndTime - lStartTime;

            System.out.println("Elapsed milliseconds: " + difference);

        }
}