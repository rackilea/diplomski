public class Data {
static StringProperty name = new SimpleStringProperty();
static StringProperty domain = new SimpleStringProperty();
static StringProperty FQDN = new SimpleStringProperty();

static {
    FQDN.bind(Bindings.format("%s@%s", name, domain));
}

public static String setName(String string) {
    name.set(string);
}

public static String setDomain(String string) {
    domain.set(string);
}

public static ObservableStringValue getFQDN() {
    return FQDN;
}
}