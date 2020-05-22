public class LogicalOpTable {
public static void main(String[] args) {

boolean p, q;
    int a = 0, b = 0;

System.out.println("P\tQ\tAND\tOR\tXOR\tNOT");

p = true; q = true;
    if(p) a = 1;
    else a = 0;
    if(q) b = 1;
    else b = 0;
    System.out.print(a + "\t" + b +"\t");
    System.out.print(printBoolean(p&q) + "\t" + printBoolean (p|q) + "\t");
    System.out.println(printBoolean2(p^q) + "\t" + printBoolean (!p));

p = true; q = false;
    if(p) a = 1;
    else a = 0;
    if(q) b = 1;
    else b = 0;
    System.out.print(a + "\t" + b +"\t");
    System.out.print(printBoolean(p&q) + "\t" + printBoolean (p|q) + "\t");
    System.out.println(printBoolean2(p^q) + "\t" + printBoolean (!p));

p = false; q = true;
    if(p) a = 1;
    else a = 0;
    if(q) b = 1;
    else b = 0;
    System.out.print(a + "\t" + b +"\t");
    System.out.print(printBoolean(p&q) + "\t" + printBoolean (p|q) + "\t");
    System.out.println(printBoolean2(p^q) + "\t" + printBoolean (!p));

p = false; q = false;
    if(p) a = 1;
    else a = 0;
    if(q) b = 1;
    else b = 0;
    System.out.print(a + "\t" + b +"\t");
    System.out.print(printBoolean(p&q) + "\t" + printBoolean (p|q) + "\t");
    System.out.println(printBoolean2(p^q) + "\t" + printBoolean (!p));
}
public static String printBoolean(boolean p) {
    return p ? "1" : "0";
}
public static String printBoolean2(boolean q) {
    return q ? "1" : "0";
}
}