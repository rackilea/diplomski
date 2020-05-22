public class MysteriousAlright {
    private int[] myStuff;

    public int mystery(int num)
    {
        for (int k = myStuff.length - 1; k >= 0; k--) {
            if (myStuff[k] < num) {
                return k;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MysteriousAlright ma = new MysteriousAlright();

        ma.setMyStuff(new int[] {4,5,6,7});

        int m  = ma.mystery(5);
        System.out.println("I called ma.mystery(5) and now m is set to " + m);

        m  = ma.mystery(3);
        System.out.println("I called ma.mystery(3) and now m is set to " + m);

        m  = ma.mystery(12);
        System.out.println("I called ma.mystery(12) and now m is set to " + m);
    }

    public void setMyStuff(int[] myStuff) {
        this.myStuff = myStuff;
    }
}