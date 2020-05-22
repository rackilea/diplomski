import java.util.regex.*
String regex="([a-zA-Z0-9]+)\\[([ ,.a-zA-Z0-9]+)\\]"
Pattern funcPattern = Pattern.compile(regex);
Matcher m = funcPattern.matcher("properCase[ARG1, ARG2, class.otherArg]");
        System.out.println("Match found: " + m.matches());
        System.out.println("Total matches are: " + m.groupCount());
        if (m.matches())
        {
            for (int index= 0 ; index <= m.groupCount(); index++)
            {
                System.out.println("Group number "+ index + "is: " +m.group(index));
            }
        }
println "Arguments: " + m.group(2).split(",");