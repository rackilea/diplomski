Runnable r = () -> {
    System.out.println("Hi");
};
// Equivalent to
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Hi");
    }
};

public interface Function<F, T> {
    T call(F arg);
}

Function<String, char[]> c = s -> ("<" + s + ">").toCharArray();
// Equivalent to
Function<String, char[]> c = new Function<>() {
    public char[] call(String s) {
        return ("<" + s + ">").toCharArray();
    }
};