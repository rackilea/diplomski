import java.util.regex.*;

class Scratch
{
    public static void main(String args[])
    {
        String xyz = "NumberOne: 264\nNumberTwo: someStringFromTable2";
        Pattern pattern = Pattern.compile("(?<=NumberOne: )([0-9]+)");
        Matcher matcher = pattern.matcher(xyz);
        int foundNumber = 0;
        if (matcher.find()) {
            foundNumber = Integer.parseInt(matcher.group());
        }
        System.out.println(foundNumber);
    }
}