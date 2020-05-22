public class test
{
    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    public test(){
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        //TODO: ....
    }

    public static void main(String args[]) {

        System.out.print(new test().comp("two","four"));

    }

    public int comp(String s1, String s2) {
        int i1 = map.get(s1);
        int i2 = map.get(s2);
        return (i1<i2 ? -1 : (i1==i2 ? 0 : 1));
    }
}