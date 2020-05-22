public interface Clawbackable{
    void clawBack()
}


public class CommissionFacade
{

    public <T extends Clawbackable> void clawBack(Collection<T> objects)
    {
        for(T object: objects) 
        {
            object.clawBack();
        }           
    }
}

public class CommissionTrns implements Clawbackable {

    public void clawback(){
       // do clawback for commissions
    }
}

public class FinanceRequest implements Clawbackable {

    public void clawBack(){
      // do clwaback for FinanceRequest
    }

}