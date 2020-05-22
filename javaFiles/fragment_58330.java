import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SO_35187662 {

    private static String REG_EX;
    private static String HTML_TEXT;

    static {
        REG_EX = "<a\\b[^>]*>(.*?)<\\/a>";
        HTML_TEXT = "<ul><li class='toclevel-1 tocsection-1'><a href='#Plot'><span class='tocnumber'>1</span> <span class='toctext'>Plot</span></a></li><li class='toclevel-1 tocsection-2'><a href='#Cast'><span class='tocnumber'>2</span> <span class='toctext'>Cast</span></a></li><li class='toclevel-1 tocsection-3'><a href='#Production'><span class='tocnumber'>3</span> <span class='toctext'>Production</span></a><ul><li class='toclevel-2 tocsection-4'><a href='#Development'><span class='tocnumber'>3.1</span> <span class='toctext'>Development</span></a></li><li class='toclevel-2 tocsection-5'><a href='#Pre-production'><span class='tocnumber'>3.2</span> <span class='toctext'>Pre-production</span></a></li><li class='toclevel-2 tocsection-6'><a href='#Casting'><span class='tocnumber'>3.3</span> <span class='toctext'>Casting</span></a></li><li class='toclevel-2 tocsection-7'><a href='#Filming'><span class='tocnumber'>3.4</span> <span class='toctext'>Filming</span></a></li><li class='toclevel-2 tocsection-8'><a href='#Post-production'><span class='tocnumber'>3.5</span> <span class='toctext'>Post-production</span></a></li><li class='toclevel-2 tocsection-9'><a href='#Music'><span class='tocnumber'>3.6</span> <span class='toctext'>Music</span></a></li></ul></li><li class='toclevel-1 tocsection-10'><a href='#Release'><span class='tocnumber'>4</span> <span class='toctext'>Release</span></a><ul><li class='toclevel-2 tocsection-11'><a href='#Marketing'><span class='tocnumber'>4.1</span> <span class='toctext'>Marketing</span></a></li><li class='toclevel-2 tocsection-12'><a href='#Merchandise'><span class='tocnumber'>4.2</span> <span class='toctext'>Merchandise</span></a></li><li class='toclevel-2 tocsection-13'><a href='#Home_media'><span class='tocnumber'>4.3</span> <span class='toctext'>Home media</span></a></li></ul></li><li class='toclevel-1 tocsection-14'><a href='#Reception'><span class='tocnumber'>5</span> <span class='toctext'>Reception</span></a><ul><li class='toclevel-2 tocsection-15'><a href='#Box_office'><span class='tocnumber'>5.1</span> <span class='toctext'>Box office</span></a><ul><li class='toclevel-3 tocsection-16'><a href='#Theatrical_run'><span class='tocnumber'>5.1.1</span> <span class='toctext'>Theatrical run</span></a></li><li class='toclevel-3 tocsection-17'><a href='#Commercial_analysis'><span class='tocnumber'>5.1.2</span> <span class='toctext'>Commercial analysis</span></a></li></ul></li><li class='toclevel-2 tocsection-18'><a href='#Critical_response'><span class='tocnumber'>5.2</span> <span class='toctext'>Critical response</span></a></li><li class='toclevel-2 tocsection-19'><a href='#Accolades'><span class='tocnumber'>5.3</span> <span class='toctext'>Accolades</span></a><ul><li class='toclevel-3 tocsection-20'><a href='#Top_ten_lists'><span class='tocnumber'>5.3.1</span> <span class='toctext'>Top ten lists</span></a></li></ul></li></ul>";
    }

    public static void main(String... args) {
        Pattern pattern = Pattern.compile(REG_EX);
        Matcher matcher = pattern.matcher(HTML_TEXT);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        } 
    }
}