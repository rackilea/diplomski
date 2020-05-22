public static void myMethod(List<? extends Comparable> struttura) {}

public static void main(String[] args) {
    List<Integer> lista = null;
    myMethod(lista); // compiles OK
}