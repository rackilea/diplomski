public class BruteForce{

    public static String password = "CBA";

    public static Character[] characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
            'z', '_', '-', '!', '$'};

    public static Integer count = 0;

    public static void main(String[] args) {
        int deep = characters.length;//password deep,default value is from one to characters.length
        rmark:
        for (int i = 1; i <= deep; i++) {
            for (int j = 0; j < characters.length; j++) {
                if(test(i,characters[j].toString())) {
                    break rmark;
                }
            }
        }
    }

    public static boolean test(int deep,String parent) {
        if(deep <= 1) {
            count++;
            System.out.println(parent);
            if(parent.equals(password)) {
                System.out.println("after generating "+count+" strings,we find the password!");
                return true;
            }
            return false;
        }else {
            for (int j = 0; j < characters.length; j++) {
                if(test(deep-1,parent+characters[j].toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}