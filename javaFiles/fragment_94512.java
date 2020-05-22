public class Demo
{
    public static void main(String[] args)
    {

        String question = "The inventor of Java was _James Gosling_";
        Pattern p = Pattern.compile("_(.*?)_");
        Matcher m = p.matcher(question);
        if (m.find())
        {
            System.out.println("question before edit : " + question);
            String answer = m.group(1);
            System.out.println("Answer after edit : " + m.group(1));
            question = question.replace(answer, "_______");

            System.out.println("question after edit : " + question);
        }
     }