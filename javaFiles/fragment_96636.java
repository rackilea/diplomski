public class Page
{
    private string pageContent;
    public Page(string content)
    {
        pageContent = content;
    }

    public void Accept(IWordVisitor visitor)
    {
        foreach (var w in pageContent.Split())
        {
            visitor.VisitWord(w);
        }
    }
}