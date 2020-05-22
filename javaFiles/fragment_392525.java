@Component
class AccountRepository {
    public AccountRepository(Foo foo) {}
}
@Component
class Foo {
    public Foo(TransferService ts) {}
}