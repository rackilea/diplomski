import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        String s1 = "com.company.project.service.service1Impl.method()";
        String s2 = "com.company.project.service.service2Impl.method()";
        String s3 = "com.company.test.service.service1Impl.method()";
        String s4 = "com.company.test.service.service2Impl.method()";
        String[] strings = { s1, s2, s3, s4 };
        t.print(strings);
    }

    public void print(String[] strings) {
        //calculate max depth
        int maxDepth = 0;
        for (String string : strings) {
            int currentDepth = string.split("\\.").length;
            if (currentDepth > maxDepth) {
                maxDepth = currentDepth;
            }
        }
        this.print(strings, "", 0, maxDepth);
    }

    public void print(String[] strings, String start, int currentDepth,
            int maxDepth) {
        if (currentDepth == maxDepth - 1) {
            return;
        }
        String currentPrint = null;
        ArrayList<String> candidates = new ArrayList<String>();

        // add candidates
        for (String s : strings) {
            if (!s.startsWith(start)) {
                continue;
            }
            String[] split = s.split("\\.");
            if (split.length - 1 < currentDepth) {
                continue;
            }
            if (currentPrint == null) {
                currentPrint = split[currentDepth];
                candidates.add(currentPrint);
                continue;
            }
            if (!currentPrint.equals(split[currentDepth])) {
                currentPrint = split[currentDepth];
                candidates.add(currentPrint);
            }
        }

        // print depth+1 with candidates
        currentDepth++;
        for (String c : candidates) {
            // print current level
            this.printSpaces(currentDepth - 1);
            System.out.println(c);
            // we have to go deeper
            this.print(strings, start + c + ".", currentDepth, maxDepth);
        }
    }

    // print spaces
    public void printSpaces(int max) {
        for (int i = 0; i < max; i++) {
            System.out.print("  ");
        }
    }
}