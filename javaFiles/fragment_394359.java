public class App
{

    public static void main(String[] args)
    {
        Gson gson =
            new GsonBuilder()
            .registerTypeAdapter(TestAnnotationBean.class, new AnnotatedDeserializer<TestAnnotationBean>())
            .create();

        String json = "{\"foo\":\"This is foo\",\"bar\":\"this is bar\"}";
        TestAnnotationBean tab = gson.fromJson(json, TestAnnotationBean.class);
        System.out.println(tab.foo);
        System.out.println(tab.bar);

        json = "{\"foo\":\"This is foo\"}";
        tab = gson.fromJson(json, TestAnnotationBean.class);
        System.out.println(tab.foo);
        System.out.println(tab.bar);

        json = "{\"bar\":\"This is bar\"}";
        tab = gson.fromJson(json, TestAnnotationBean.class);
        System.out.println(tab.foo);
        System.out.println(tab.bar);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonRequired
{
}

class TestAnnotationBean
{
    @JsonRequired public String foo;
    public String bar;
}

class AnnotatedDeserializer<T> implements JsonDeserializer<T>
{

    public T deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException
    {
        T pojo = new Gson().fromJson(je, type);

        Field[] fields = pojo.getClass().getDeclaredFields();
        for (Field f : fields)
        {
            if (f.getAnnotation(JsonRequired.class) != null)
            {
                try
                {
                    f.setAccessible(true);
                    if (f.get(pojo) == null)
                    {
                        throw new JsonParseException("Missing field in JSON: " + f.getName());
                    }
                }
                catch (IllegalArgumentException ex)
                {
                    Logger.getLogger(AnnotatedDeserializer.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (IllegalAccessException ex)
                {
                    Logger.getLogger(AnnotatedDeserializer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return pojo;

    }
}