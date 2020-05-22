import lotus.domino.Database;
import lotus.domino.Document;

public interface NotesSelectionContext
{
    public Database getDatabase();

    public Document getDocument();

    public String getField();
}