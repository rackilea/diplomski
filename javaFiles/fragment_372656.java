public class SplitData {

    public static void main(String[] args) {
        String[] array = {"120030125  J Blog   23, SOME HOUSE, QUEENS       259.44  21-OCT-2013  17-NOV-2013",
            "120030318  R Mxx    37,WOODCLOSE,BIRMINGHAM,  121.96  16-OCT-2013  17-NOV-2013  Y 0",
            "120012174  JE xx    25, SOME HOUSE,QUEENS       259.44  21-OCT-2013  17-NOV-2013",
            "100154992  DL x     23, SOME HOUSE, QUEENS       259.44  21-OCT-2013  17-NOV-2013  Y"  
        };

        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        for (String s : array) {
            String[] split = s.split("\\s+");
            s1 = split[0];
            s2 = split[1] + " " + split[2];
            for (String string: split) {
                if (string.matches("\\d+\\.\\d{2}")) {
                    s3 = string;
                    break;
                }
            }
            String[] newArray = s.substring(s.indexOf(s3)).split("\\s+");
            s4 = newArray[1];
            s5 = newArray[2];

            System.out.printf("%s\t%s\t%s\t%s\t%s\n", s1, s2, s3, s4, s5);
        }
    }  
}