import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        final String regex = "^(?:AMDF|SB700).*\\.(?!tmp$)[^.]+$";
        final String[] files = {
            "AMDF123978sudjfadfs.ext",
            "SB700afddasjfkadsfs.ext",
            "AMDE41312312089fsas.ext",
            "SB701fs98dfjasdjfsd.ext",
            "AMDF123120381203113.tmp"
        };

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        for (String file:files) {
            final Matcher matcher = pattern.matcher(file);
            if(matcher.matches()) {
                System.out.println(matcher.group(0));
            }
        }
    }
}