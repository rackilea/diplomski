public class Program {
    public static int Puzzle(int n) {
    int x = n -1;
    //sum of first n-1 squares
    return x*(x+1)*(2*x+1)/6;
    }
}