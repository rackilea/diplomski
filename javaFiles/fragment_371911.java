public JPopupMenu createSharedPopupMenu()
{
    JPopupMenu popup = new JPopupMenu()

    JMenuItem copy = new JMenuItem( new DefaultEditorKit.CopyAction() );
    popup.add( copy );
    ...

    return popup.
}