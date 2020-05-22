public interface Reportfile<T>
{
    public T parseReadFile();
}

public class Masterfile implements Reportfile<Set<Masterpojo>> 
{
    public Set<Masterpojo> parseReadfile()
    {
        ...
    }
}

public class Transfile implements Reportfile<List<Transpojo>> 
{
    public List<Transpojo> parseReadfile()
    {
        ...
    }
}