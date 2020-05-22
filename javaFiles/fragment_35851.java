public boolean editCellAt(int row, int column, EventObject e)
{
    boolean result = super.editCellAt(row, column, e);
    final Component editor = getEditorComponent();

    if (editor != null && editor instanceof JTextComponent)
    {
        ((JTextComponent)editor).selectAll();

        if (e == null)
        {
            ((JTextComponent)editor).selectAll();
        }
        else if (e instanceof MouseEvent)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    ((JTextComponent)editor).selectAll();
                }
            });
        }

    }

    return result;
}