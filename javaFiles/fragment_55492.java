import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
static final Pattern ANCHOR_PATTERN = Pattern.compile(
        "<a\\s+(?:[^>]+\\s+)?class\\s*=\\s*(?:whtbigheader(?=\\s|>)|(['\"])(?:(?:(?!\\1).)*?\\s+)*whtbigheader(?:\\s+(?:(?!\\1).)*?)*\\1)[^>]*>(.*?)</a>",
        Pattern.CASE_INSENSITIVE
);
public static String getAnchorContents( final String html ){
    final Matcher matcher = ANCHOR_PATTERN.matcher( html );
    if ( matcher.find() ){
        return matcher.group(2);
    }
    return null;
}

public static void main( final String[] args ){
    final String[] tests = {
            "<a class=whtbigheader>test</a>",
            "<a class=\"whtbigheader\">test</a>",
            "<a class='whtbigheader'>test</a>",
            "<a class =whtbigheader>test</a>",
            "<a class =\"whtbigheader\">test</a>",
            "<a class ='whtbigheader'>test</a>",
            "<a class= whtbigheader>test</a>",
            "<a class= \"whtbigheader\">test</a>",
            "<a class= 'whtbigheader'>test</a>",
            "<a class = whtbigheader>test</a>",
            "<a class\t=\r\n\"whtbigheader\">test</a>",
            "<a class =\t'whtbigheader'>test</a>",
            "<a class=\"otherclass whtbigheader\">test</a>",
            "<a class=\"whtbigheader otherclass\">test</a>",
            "<a class=\"whtbigheader2 whtbigheader\">test</a>",
            "<a class=\"otherclass whtbigheader otherotherclass\">test</a>",
            "<a class=whtbigheader href=''>test</a>",
    };
    int successes = 0;
    int failures = 0;
    for ( final String test : tests )
    {
        final String contents = getAnchorContents( test );
        if ( "test".equals( contents ) )
            successes++;
        else
        {
            System.err.println( test + " => " + contents );
            failures++;
        }
    }
    final String[] failingTests = {
            "<a class=whtbigheader2>test</a>",
            "<a class=awhtbigheader>test</a>",
            "<a class=whtbigheader-other>test</a>",
            "<a class='whtbigheader2'>test</a>",
            "<a class='awhtbigheader'>test</a>",
            "<a class='whtbigheader-other'>test</a>",
            "<a class=otherclass whtbigheader>test</a>",
            "<a class='otherclass' whtbigheader='value'>test</a>",
            "<a class='otherclass' id='whtbigheader'>test</a>",
            "<a><aclass='whtbigheader'>test</aclass></a>",
            "<a aclass='whtbigheader'>test</a>",
            "<a class='whtbigheader\"'>test</a>",
            "<ab class='whtbigheader'><a>test</a></ab>",
    };
    for ( final String test : failingTests )
    {
        final String contents = getAnchorContents( test );
        if ( contents == null )
            successes++;
        else
        {
            System.err.println( test + " => " + contents );
            failures++;
        }
    }
    System.out.println( "Successful tests: " + successes );
    System.out.println( "Failed tests: " + failures );
}
}