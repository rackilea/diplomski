public interface Function1<RESULT,INPUT> {
    RESULT call(INPUT input);
}

public class Sin implements Function1<Double,Double> {
    public static final Sin instance = new Sin();
    private Sin() {
    }
    public Double call(Double x) {
        return Math.sin(x);
    }
}

public Double needToDo(Function1<Double,Double> aFunction, Double x0Par, Double hPar) {
   Double d1 = aFunction.call(x0Par);
   Double d2 = aFunction.call(hPar);
   return d1 > d2 ? d1 : d2;
}

public static void main(String[] args) {
    Double x0Par = 10.2;
    Double hPar = 1.9;
    Double ret = needToDo(Sin.instance, x0Par, hPar);
    System.out.println(ret);
}