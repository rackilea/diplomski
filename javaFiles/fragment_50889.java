class App
{
    @Bind("msg10")
    private String msg1;
    @Bind("msg11")
    private String msg2;

    //setters & getters
}

public class PropertyBinder 
{

    public static void main(String[] args) throws IOException, IllegalAccessException 
    {
        Properties props = new Properties();
        InputStream stream = PropertyBinder.class.getResourceAsStream("/app.properties");
        props.load(stream);
        System.out.println(props);
        App app = new App();
        bindProperties(props, app);

        System.out.println("Msg1="+app.getMsg1());
        System.out.println("Msg2="+app.getMsg2());

    }

    static void bindProperties(Properties props, Object object) throws IllegalAccessException 
    {
        for(Field field  : object.getClass().getDeclaredFields())
        {
            if (field.isAnnotationPresent(Bind.class))
            {
                Bind bind = field.getAnnotation(Bind.class);
                String value = bind.value();
                String propValue = props.getProperty(value);
                System.out.println(field.getName()+":"+value+":"+propValue);
                field.setAccessible(true);
                field.set(object, propValue);
            }
        }
    }
}