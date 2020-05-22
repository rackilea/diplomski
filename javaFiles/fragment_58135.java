public class Test1 {

    public static void main(String args[]){

        int per1= 100, g1=3;

        String name1="AAA PPPP";

        int per2= 55, g2=4;

        String name2="BBB QQQ";

        int per3= 24, g3=7;

        String name3="CCC RRRRR";

        String space = "";

        System.out.println(String.format("%d%%%-" + (4 - String.valueOf(per1).length()) + "s| %02d strike | %s", per1, space, g1, name1));
        System.out.println(String.format("%d%%%-" + (4 - String.valueOf(per2).length()) + "s| %02d strike | %s", per2, space, g2, name2));
        System.out.println(String.format("%d%%%-" + (4 - String.valueOf(per3).length()) + "s| %02d strike | %s", per3, space, g3, name3));
    }
}