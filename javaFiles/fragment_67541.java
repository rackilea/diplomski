public class Test007 {

    public static void main(String[] args) {

        String dinheiro="5121322";

        int i = dinheiro.length() % 3;

        String s1 = "";

        s1 = dinheiro.substring(0, i);

        String s2 = "";

        for (int k=i; k<dinheiro.length(); k+=3){
            if (k!=i || i>0){
                s2 += " ";
            }
            s2 += dinheiro.substring(k, k+3);
        }

        System.out.println(s1 + s2);

    }

}