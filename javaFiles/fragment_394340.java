public void addNote(String note)
{
    notes.add(note);
}
public void deleteNote(int index)
{
    if(index < notes.size())
         notes.remove(index);
}
public int getNoteNumber(String note)
{
    for(int i=0; i<(notes.size()); i++)
    {
        if(notes.get(i).equals(note))
            return i;
    }
    return -1;  //Note does not exist

}
public String getNote(int index)
{
     if(index < notes.size())
     return notes.get(i);
}

public void setNote(int position, String text)
{
    if(position < notes.size())
         notes.set(position,text);

}