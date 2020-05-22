import java.util.ArrayList;

class PageContents
{
    String Line;

    public String getLine()
    {
        return Line;
    }

    public void setLine(String line)
    {
        Line = line;
    }

}

public class MainClass
{
    public static void main(String[] args)
    {
        ArrayList<ArrayList<PageContents>> book = new ArrayList<>(); 
        ArrayList<PageContents> page1 = new ArrayList<>();

        // Add new(first) page in book.
        PageContents pageContents1 = new PageContents();
        pageContents1.setLine("This is Line 1 on Page 1"); 
        page1.add(pageContents1); 
        book.add(page1);

        ArrayList<PageContents> page2 = new ArrayList<>();
        PageContents pageContents2 = new PageContents();
        pageContents2.setLine("This is Line 1 on Page 2");
        page2.add(pageContents2);
        book.add(page2);

        System.out.println("Page1 size: " + book.get(0).size() + "pages");
        System.out.println("Page1: " + book.get(0).get(0).getLine());

        System.out.println("Page2 size: " + book.get(1).size() + "pages");

        if (book.get(1).isEmpty())
        {
            System.out.println("Page2: EMPTY");
        } else {
            System.out.println("Page2: " + book.get(1).get(0).getLine());
        }
    }
}