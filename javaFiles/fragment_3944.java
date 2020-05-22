public enum ServiceProviderType {
    FOO {
        @Override public <T> T apply(Action<T> action) { return action.doFoo(); }
    },
    BAR {
        @Override public <T> T apply(Action<T> action) { return action.doBar(); }
    };

    public interface Action<T> {
        T doFoo();
        T doBar();
    }

    public abstract <T> T apply(Action<T> action);

    public static ServiceProviderType checkService(String url) {
        if (url.equals("http://www.example.com"))
            return FOO;
        return BAR;
    }
}

public class LayerServiceProviderType implements ServiceProviderType.Action<String> {
    @Override
    public String doFoo() {
        return "#ff0000";
    }
    @Override
    public String doBar() {
        return "#ff0000";
    }
}

public class Main {
    public static void main(String[] args) {
        ServiceProviderType type = ServiceProviderType.checkService("");

        String colour = type.apply(new LayerServiceProviderType());
    }
}