import acm.program.*;

public class AddingOddNumbers extends ConsoleProgram {
    public void run() {
        int n = readInt("enter a positive nunber: ");
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (n == 1) {
                println(1);
            } else {
                println((i * 2) + 1);
                total += (i * 2) + 1;
            }
        }
        println("total : " + total);
    }
}