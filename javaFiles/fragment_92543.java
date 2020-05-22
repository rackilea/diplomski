//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Scanner;

public double xirr_issue5b() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Scanner sc = new Scanner(System.in);
    ArrayList<Transaction> trans = new ArrayList<Transaction>();
    int iterations = sc.nextInt();

    for(int k = 0; k < iterations; k++) {
        trans.add(new Transaction(sc.nextInt(), format.parse(sc.next())));
    }

    double rate = Xirr(trans).xirr();
    sc.close();

    return rate;
}