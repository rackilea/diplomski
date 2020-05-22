public class WordStatisticsBuilder : IReportBuilder
{
    private Report report;
    private Page page;

    public WordStatisticsBuilder(Page page)
    {
        report = new Report();
        this.page = page;
    }

    public void Execute()
    {
        var psv = new PageStatisticVisitor();
        page.Accept(psv);            
        foreach (var s in psv.Stats)
        {
            report.AddLine(string.Format("{0} : {1}", s.Key, s.Value));
        }
    }

    public IReport Product
    {
        get { return report; }
    }
}