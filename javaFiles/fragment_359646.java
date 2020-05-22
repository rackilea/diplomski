class CreditCard{
    int pin, balance;
    private Callback callback;
    CreditCard(Callback callback){
        this.callback=callback;
    }

    public void pinChange(int pin){
        this.pin=pin;
        //inform the listener as well
        callback.pinChanged();
    }

    public void withdraw(int amount){
        this.balance-=amount;
        //inform the the listener
        if(balance<1000)callback.lowBalance();
    }
}

class MyListener implements Callback{
    public void pinChanged(){
        //do what is needed when somebody changes pin..
       //i.e send sms to the customer 
        System.out.println("PIN changed..");
    }

    public void lowBalance(){
        //inform the customer about lowbalance.
        System.out.println("little money in card..");
    }

    main(String... args){
        CreditCard cc=new CreditCard(new MyListener());
        cc.changePin(3306);
    }
}