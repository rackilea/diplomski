public class AwesomeClass
{
    public AwesomeClass()
    {
        CoolClass coolClass = new CoolClass();
        PrettyClass prettyClass = new PrettyClass( coolClass );  // change
    }
}

public class CoolClass()
{
    private Color colour;  // change

    public CoolClass
    {
        colour = Color.RED;  // change
    }

    public void setColor( Color color ) {  // add setter
      colour = color;
    }
}

public class PrettyClass
{

    public PrettyClass( CoolClass cc )  // change
    {
        //I want to set coolClass's colour to Color.BLACK here
        cc.setColor( Color.BLACK );  // change
    }
}