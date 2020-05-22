public class AccountData {
    private String id;
    private String name;

    public AccountData(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class CreditCardAccountData extends AccountData {
    private int limit;

    public CreditCardAccountData(String id, String name, int limit) {
        super(id, name);
        this.limit = limit;
    }
}