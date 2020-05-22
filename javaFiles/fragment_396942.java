public class TestBreak {
    public static void main(String[] args) {
        int i = 10;
        int j = 5;
        int a[] = {5, 10, 6, 90, 0, 1, 0, 7, 10};
        for(; j<i; j++){
            if(a[j] == 0) break;
        }
    }
}