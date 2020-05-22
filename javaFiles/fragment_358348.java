public class AA {

    public AA() {

    }

    @Transactional
    public void test() {
        System.out.println("" + getClass().getName());
    }
}