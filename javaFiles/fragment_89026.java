shell.addListener(SWT.Close, new Listener() 
                {
                    public void handleEvent(Event event) 
                    {
                        event.doit = false;
                    }
                });