private int ans;
@Override
public int add(int a, int b) {
   ans = a + b;
   System.out.println("ICalculator - add " + a + " und " + b + "= " + ans);
   return ans;
}
@Override
public int subtract(int a, int b) {
   ans = a -b;
   System.out.println("ICalculator - subtract " + a + " und " + b
     + "= " + ans);
   return ans;
}