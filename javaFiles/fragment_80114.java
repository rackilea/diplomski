public class MyClass 
{
    public static int index=0;

    public static void getIndex()
    {
       index++;
       System.out.println("Index:"+index);
       if(index>10)
            index=0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            getIndex();
        }
    }
}