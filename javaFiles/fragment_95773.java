package foo.bar.service;
public class DefaultService implements Service{
    @Override
    public void whack(final String thing, final Integer thang){
        System.out.println(
            "Inside thing: " + thing + ", inside thang: " + thang
        );
    }
}