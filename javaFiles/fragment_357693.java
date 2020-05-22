@Override
public void mouseClicked(MouseEvent e)
{
    // Some pre-processing here. Determine row at mouse click location
    int cursorType = fTable.getCursor().getType();
    if(e.getClickCount == 2 && 
      (cursorType == Cursor.N_RESIZE_CURSOR || cursorType == CURSOR.S_RESIZE_CURSOR))
    {
        // Resize row appropriately.
    }
}