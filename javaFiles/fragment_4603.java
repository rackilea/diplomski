class AbstractUser<T extends AbstractType, A extends AbstractAccount<T>> {

    private Supplier<T> accountSupplier;

    public AbstractUser(Supplier<T> accountSupplier) {
        this.accountSupplier = accountSupplier;
    }

    protected T getType() {
        return accountSupplier.get();
    }
}