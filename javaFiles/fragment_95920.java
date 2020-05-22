public class CheckSynthetic {
    public static void main(String[] args) {
        new CheckSynthetic().check(true);
    }
    private void check(boolean b) {
        print(getClass());
        print(new Runnable() { public void run() { check(!b); } }.getClass());
        print(((Runnable)() -> check(!b)).getClass());
    }
    private void print(Class<?> c) {
        System.out.println(c.getName()+", synthetic: "+c.isSynthetic());
        Stream.of(c.getDeclaredFields(),c.getDeclaredConstructors(),c.getDeclaredMethods())
            .flatMap(Arrays::stream)
            .forEach(m->System.out.println("\t"+m.getClass().getSimpleName()+' '+m.getName()
                                           +", synthetic: "+m.isSynthetic()));
    }
}