public class GenericList <T> extends ArrayList<T>
{
     private Class<T> genericType;

     public GenericList(Class<T> c)
     {
          this.genericType = c;
     }

     public Class<T> getGenericType()
     {
          return genericType;
     }
}