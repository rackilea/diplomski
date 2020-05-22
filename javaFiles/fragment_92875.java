public class Test1 {
    int i1 = 1;
    int i2 = 1;

    public static void main(String[] args) throws Exception {
        Runtime rt = Runtime.getRuntime();
        long m0 = rt.totalMemory() - rt.freeMemory();
        Map m = new HashMap();
        m.put("i1", 1);
        m.put("i2", 1);
        //Test1 t1 = new Test1();  
        long m1 = rt.totalMemory() - rt.freeMemory();
        System.out.println(m1 - m0);
    }
}