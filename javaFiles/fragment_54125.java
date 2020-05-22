package ExceptionTest;

public class Main {

    public static void main(String[] args) {
        exceptionTester();
    }

    private static void exceptionTester(){
        try{         
            new FirstLevelObj().begin();        
        }
        catch(MyException e){
            System.out.println("Its worked!");
            e.printStackTrace();
        }
        finally{
            System.out.println("Oh young man..This Class doth created the other classes! \nAnd has now thrown the exception!");
        }

    }

}

package ExceptionTest;

public class FirstLevelObj {

    private SecondLevelObj second;

    public FirstLevelObj() throws MyException{
    }

    protected void begin()throws MyException{
        try{
            second = new SecondLevelObj();
            second.start();
        }
        catch(MyException e){
            throw new MyException("This Is The One!");
        }
        finally{
            System.out.println("And finally..");
        }
    }

}

package ExceptionTest;

public class SecondLevelObj {

    public SecondLevelObj(){

    }

    protected void start() throws MyException{
        for(int i = 0; i<10; i ++){
            if(i == 6){
                System.out.println("Exception should be thrown:");
                throw new MyException("An Error Hath Occurred Young Man!");
            }
            else{
                System.out.println(i);
            }
        }
    }
}

package ExceptionTest;

public class MyException extends Exception{
    public MyException(String s){
        super(s);
    }
}