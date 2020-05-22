public class BankAccount{
    private int amount;
    private Queue<Action> actionList=new LinkedList<Action>();

    public void withDraw(int k){
        Action a = new withdrawAction();
        a.doAction(k);
        if(actionList.size()<10){
            actionList.offer(a);
        }
        else{
            actionList.poll();
            actionList.offer(a);
        }
    }

    public void deposit(int k){
        Action a = new DepositAction();
        a.doAction(k);
        if(actionList.size()<10){
            actionList.offer(a);
        }
        else{
            actionList.poll();
            actionList.offer(a);
        }
    }

    abstract class Action{  
        String actionDesc=null;
         abstract void doAction(int k);
         abstract void printAction();
    }

    class DepositAction extends Action{
        @Override
        void doAction(int k) {
            amount=amount+k;
            actionDesc="Deposit: "+k;
        }
        @Override
        void printAction() {
            System.out.println(actionDesc);
        } 
    }

    class withdrawAction extends Action{
        @Override
        void doAction(int k) {
            if(amount-k<0){
                throw new IllegalArgumentException();
            }
            amount=amount-k;
            actionDesc="Withdraw: "+k;
        }
        @Override
        void printAction() {
            System.out.println(actionDesc);
        }
    }
}