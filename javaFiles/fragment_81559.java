public static void main(String[] args) throws ScriptException
{

    String equation = "3x^2 - 4x^3 + 3x^3";
    int x = 4;

    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");

    System.out.println(engine.eval(fixEquation(equation, x)));


}


public static String fixEquation(String equation, int x)
{
    StringBuilder sb = new StringBuilder(equation.replaceAll(" ", ""));
    StringBuilder fixed = new StringBuilder("(");
    StringBuilder temp = new StringBuilder("");


    for(int i = 0; i < sb.length(); i++)
    {

        if(sb.charAt(i)=='^')
        {
            for(int j = i + 1; j < sb.length(); j++)
            {
                if(j + 1 == sb.length())
                {
                    temp.append(sb.charAt(j));
                    for(int k = 0; k < Integer.valueOf(temp.toString()); k++)
                        fixed.append( "*" + x);
                    temp.replace(0, temp.length(), "");
                    i = sb.length();
                    break;
                }
                if(sb.charAt(j) == '+' || sb.charAt(j) == '-' )
                {
                    for(int k = 0; k < Integer.valueOf(temp.toString()); k++)
                        fixed.append( "*" + x);
                    temp.replace(0, temp.length(), "");
                    i = j - 1;
                    break;
                }
                temp.append(sb.charAt(j));

            }
        }
        else if(sb.charAt(i)=='x' && (i + 1 == sb.length() || sb.charAt(i + 1) != '^'))
        {
            fixed.append("*"+ x) ;
        }
        else if(sb.charAt(i)=='x' )
        {
            fixed.append("") ;
        }
        else if(sb.charAt(i) == '+' || sb.charAt(i) == '-')
        {
            fixed.append(")" + sb.charAt(i) + "(");
        }
        else
            fixed.append(sb.charAt(i));
    }

    fixed.append(")");
    return fixed.toString();
}