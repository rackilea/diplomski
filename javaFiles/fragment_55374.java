package my;

class ImplimentPkg extends Multiplication {
    public static void main(String args[]) {

        Multiplication obj = new ImplimentPkg();
        System.out.println(obj.mul(2, 4));

    }

    protected int mul(int a, int b) {

        System.out.println("");
        return 0;
    }
}