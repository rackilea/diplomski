public interface SubApp<T extends Object> {
    public String talk(Result<T> result);
}

class A implements SubApp<String> {
    @Override
    public String talk(Result<String> result) { ... }
}