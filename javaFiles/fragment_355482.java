import static somepackage.Replacer.replace;

public class Main {

    public static void main(String[] args) {
        int calculationTo = 3;

        calculationTo = replace(calculationTo).with(0).when(calculationTo < 1);
    }

}