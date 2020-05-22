import lotus.domino.*;
public class sample extends NotesThread
{
  public static void main(String argv[])
    {
        sample mySample = new sample();
        mySample.start();
    }
  public void runNotes()
    {
    try
      {
        Session s = NotesFactory.createSession();
        Database db = s.getDatabase ("Server", "pathToMailDB.nsf");
        View vw = db.getView ("By Person");  // this view exists in r8 mail template; may need to change for earlier versions
        Document doc = vw.getFirstDocument();
        while (doc != null) {               
            System.out.println (doc.getItemValueString("Subject"));
            doc = vw.getNextDocument(doc);
        }
      }
    catch (Exception e)
      {
        e.printStackTrace();
      }
    }
}