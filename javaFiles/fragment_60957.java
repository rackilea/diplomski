public class Test
{
    public static void main(String[] args) {
        String s =  "{\n" +
                    "items = [{\n" +
                    "VALUE1 = 1,\n" +
                    "VALUE2 = v1,\n" +
                    "VALUE3 = high temp,\n" +
                    "VALUE4 = null\n" +
                    "\n" +
                    "}, {\n" +
                    "VALUE1 = 1,\n" +
                    "VALUE2 = v1,\n" +
                    "VALUE3 = low temp,\n" +
                    "VALUE4 = null\n" +
                    "}, {\n" +
                    "VALUE1 = 1,\n" +
                    "VALUE2 = v1.1,\n" +
                    "VALUE3 = Not valid,\n" +
                    "VALUE4 = null\n" +
                    "}]";
[A-F0-9]{2}(:[A-F0-9]{2})*:?");
        String json = s.replaceAll("\\b(\\w+)\\s*=\\s*", "\"$1\": ");
        json = json.replaceAll("(?<=\": )(?!\\[|\\{|(?:(?:null|\\d+)[,}\n]))([^,}\n]*)", "\"$1\"");
        System.out.println(json);
    }
}