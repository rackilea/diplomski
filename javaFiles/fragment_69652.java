@Override
public void execute(Runnable command)
{
    beforeExecute(Thread.currentThread(), command);
    super.execute(command);
}