public void runInBackgroud(final String msg)
{
    SwingWorker<Object, Object> task = new SwingWorker<Object, Object> ( )
    {
        public Object doInBackground()
        {
            write(msg);
            return null;
        }
        public void done()
        {}
    };
    task.execute ( );
}