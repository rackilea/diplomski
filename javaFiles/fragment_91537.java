import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest{
    public static void main(String[] args){
        String string = "fregtreDFGDFG5464SOMENAME_WITH_%20.emx#SOMETHING_WITH_NUMBERS_" +
                "AND_ALPHABETS?SOMENAME_WITH_%20/SOME_OTHER_NAME_WITH_%20AL12345?" +
                "SDFSFDSFSDfdste5464565yGFDGdfgdfgdfgdfgTRy45y/retertre?retertreterERter" +
                "45345435XYZ%20DEF.emx#ZMP_00234C3B7?XYZ%20DEF/ABC_AL12345?%?54654DFGDfg?5656//56456";
        Pattern pattern = Pattern.compile("(\\w+%\\w+)\\.emx#[\\w%]+\\?\\1\\/[\\w%]+AL\\d{5}\\?");
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()) {
            System.out.println(string.substring(matcher.start(), matcher.end()));
            System.out.println();
        }
    }
}