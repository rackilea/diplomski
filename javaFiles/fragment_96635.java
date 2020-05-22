public class PageStatisticVisitor : IWordVisitor
{
    private readonly IDictionary<string, long> stats;

    public PageStatisticVisitor()
    {
        stats = new Dictionary<string, long>();
    }

    public IDictionary<string, long> Stats { get { return stats; } }

    public void VisitWord(string word)
    {
        long currentStat;
        if (stats.TryGetValue(word, out currentStat)) currentStat++;
        else currentStat = 1;
        stats[word] = currentStat;
    }
}