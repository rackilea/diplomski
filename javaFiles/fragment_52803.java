import java.lang.*;
import java.util.regex.*;
import java.util.*;

public class test{

    public test()
    {
        super();
    }
    public static void main(String[] arg)
    {
          ResultJoin rj=new ResultJoin();
          for(int i=0;i<10;i++)
          {
            Task t=new Task(1.0*i,2.0*i);
            new Emmitable(rj,t).start();
          }
          System.out.println(rj.getReuslt());
          return;
    }
}

interface TaskInterface
{
    public double calcu();
}

interface ResultInterface
{
    public void pushResult(double dat);
    public double getReuslt();
}


class Emmitable extends Thread
{
    private ResultInterface result=null;
    private TaskInterface task=null;

    public Emmitable(ResultInterface rj,TaskInterface tsk)
    {result=rj;task=tsk;}

    public void run()
    {
        result.pushResult(task.calcu());
    }

}
class ResultJoin implements ResultInterface
{
    private double sum=0;
    public ResultJoin()
    {}
    public synchronized void pushResult(double i)
    {
        sum+=i;
    }
    public synchronized double getReuslt()
    {
        double result=sum;
        return sum;
    }
}

class Task implements TaskInterface
{
    private double a;
    private double b;
    public Task(double na,double nb)
    {
        a=na;b=nb;
    }
    public double calcu()
    {
        return 1.0*a*b;
    }
}