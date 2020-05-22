import lotus.domino.NotesException;

public interface NotesSelectionObserver
{
    void onSelectionChange(NotesSelectionContext cContext) throws NotesException;

    void onUpdateAfterSelectionChange();
}