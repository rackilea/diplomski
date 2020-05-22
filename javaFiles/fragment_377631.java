public class UMLAccessModifier
{
    private String modifier;

    public UMLAccessModifier(String input)
    {   
        if(input.toLowerCase().contains("public"))
        {
            modifier = "public";
        }

        else if(input.toLowerCase().contains("protected"))
        {
            modifier = "protected";
        }

        else 
        {
            modifer = "private";
        }
    }

    public String getModifier() 
    {
        return modifier;
    }
}