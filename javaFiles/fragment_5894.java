import java.util.ArrayList;

public class MyRandom {

    public static void main(String[] args) {
        System.out.println(getRandom(4));
        System.out.println(getRandom(4));
        System.out.println(getRandom(10));
    }

    public static String getRandom(int length){
        if (length>10) return "Hexadecimal?";
        ArrayList<Integer> numbers=new ArrayList<Integer>();
        while (length>0){
            int digit=(int)(Math.random()*10);
            if (numbers.contains(digit)) continue;
            numbers.add(digit);
            length--;
        }
        StringBuilder sb=new StringBuilder();
        for (Integer integer : numbers) {
            sb.append(integer);
        }
        return sb.toString();
    }
}