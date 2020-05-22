public class Main{

    int cnt = 0, cntNull = 0;
    public static void main(String[] args) { 
        new Main().test();
    }

    public void test(){
        for( Integer idx = 0; idx < 200000; idx++ )
        {
            loseType(0.45642f, idx);
        }
        System.out.println(cnt + " error");
        System.out.println(cntNull + " null");
    }

    public void loseType(Object data, Integer i){
        try{
            gainType((Double)data);
        } catch(ClassCastException e){
            cnt++;
            if(e.getMessage() == null){
                cntNull++;
            }
        }
    }

    public void gainType(Double x){

    }
}