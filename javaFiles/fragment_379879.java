public class StringTest {
    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.test();
    }

    public void test(){
        String s1 = " abc@123.net , efg@123.net , hig@123.net , klm@123.net , ";
        String s2 = "hig@123.net , ";
        String s3 = s1.replace(s2, "");
        System.out.println(s3);
    }   
}