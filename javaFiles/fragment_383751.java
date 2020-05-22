public class Test {     
    public static void main(String[] args) {
        String[] saveSpace = {
            "abcd: 1234",
            "abcd : 1234",
            "abcd : abcd dgdfgdf abcd dgdsfsdf",
            "abcd 1234",
            "asdasdas abcd abcd: sdfdsf"
        };

        String regex = "abcd(?!\\s*\\w)(?=(?:[^:]*\\:){1}[^:]*$)";
        String replace = "xyz";

        for(int i = 0; i<saveSpace.length; i++) {
            saveSpace[i] = saveSpace[i].replaceFirst(regex, replace);
            System.out.println(saveSpace[i]);
        }
    }
}