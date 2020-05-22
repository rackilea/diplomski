public void reorderSelection()
{
    int min = selectionCount;
    int temp = 0;

    for( int scan = selectionCount ; scan < selection.length - 1 ; scan++ )
    {
        min = scan;

        for(int i = scan + 1; i < selection.length ; i++)
        {
            if(selection[min] > selection[i])  min = i;
        }

        if(min != scan)
        {
            temp = selection[scan];
            selection[scan] = selection[min];
            selection[min] = temp;
        }
    }
}