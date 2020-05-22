public void contentsChanged(final ListDataEvent evt)
{
    if (!EventQueue.isDispatchThread())
    {
        log.debug("Delegating contentsChanged(...) to EDT");

        EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                contentsChanged(evt);
            }
        });
        // don't run ensureIndexIsVisible twice:
        return;
     }

     if (playbackInProgress)
     {
         int index = evt.getIndex0();
         currentContentList.ensureIndexIsVisible(index);
     }
}