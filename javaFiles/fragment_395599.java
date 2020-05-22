class AnswerWorker extends SwingWorker<Integer, Integer>
{
    protected Integer doInBackground() throws Exception
    {
        // Do a time-consuming task.
        Thread.sleep(1000);
        return 42;
    }

    protected void done()
    {
        try
        {
            JOptionPane.showMessageDialog(f, get());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}