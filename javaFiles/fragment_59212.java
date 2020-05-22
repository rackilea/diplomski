@Override
public void processMessage(Chat arg0, Message arg1) {
    // TODO Auto-generated method stub

    try
    {
        SwingUtilities.invokeAndWait(new Runnable()
        {

            @Override
            public void run()
            {
                board.setText(board.getText() + arg1.getBody());
            }
        });
    }
    catch (InvocationTargetException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (InterruptedException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println(arg1.getFrom() + ":" + arg1.getBody().toString());

}