public interface IReport
{
    void Print();
}

public class Report : IReport
{
    private readonly IList<string> lines;

    public Report()
    {
        lines = new List<string>();
    }

    public void AddLine(string line)
    {
        lines.Add(line);
    }
    public void Print()
    {
        foreach (var l in lines) Console.Out.WriteLine(l);
    }
}