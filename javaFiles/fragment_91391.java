public class Hanoi{

static int stepsCounter = 0; // new Code here.

public static void Han(int m, char a, char b, char c){
if(m>0){
stepsCounter++; // new Code here.
Han(m-1,a,c,b);
System.out.println("Move disc from "+a+" to "+b);
Han(m-1,b,a,c);
}
}

public static void main(String[]args){
Scanner h = new Scanner(System.in);
int n;
System.out.println("How many discs : ");
n = h.nextInt();
Han(n, 'A', 'B', 'C');
System.out.println("Steps : " + stepsCounter); // new Code here.
}
}