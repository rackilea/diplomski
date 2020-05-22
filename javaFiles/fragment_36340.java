final Pattern outerPattern = Pattern.compile("(.*?) \\((\\d+),(\\d+)\\) \\((\\d+),(\\d+)\\) (\\d+) (\\d+)(.*)");
final Pattern optionalTouplePattern = Pattern.compile(" \\((\\d+),(\\d+),(\\d+)\\)");

final BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
boolean isMatched;

do
{
    System.out.println("Please enter right format:");
    Matcher m = outerPattern.matcher(stdin.readLine());
    if (isMatched = m.find())
    {
        System.out.println(String.format("name='%s', first touple: [%s,%s], second touple: [%s,%s], first single number: %s, second single number: %s", m.group(1), m.group(2), m.group(3), m.group(4), m.group(5), m.group(6), m.group(7)));
        m = optionalTouplePattern.matcher(m.group(8));
        while(m.find())
        {
            System.out.println(String.format("+ optional touple: [%s,%s,%s]", m.group(1), m.group(2), m.group(3)));
        }
    }
}while(!isMatched);