public class StringDemo {
        public static void main(String[] args) {
            String str = "[ 1234abcd , 3456efgh]";
            str = str.substring(1, str.length()-1);
            String AfterSplit[] = str.split(",");
            System.out.println(AfterSplit[0]+"  "+AfterSplit[1]);
        }
    }