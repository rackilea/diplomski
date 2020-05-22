class User {
    private Optional<Address> address;

    boolean hasAddress() {
        return address.isPresent();
    }

    // still exposes address to the consumer, guard your properties
    void ifAddressPresent(Consumer<Address> then) {
        address.ifPresent(then::accept);
    }

    // does not expose address, but caller has no info about it
    void ifAddressPresent(Runnable then) {
        address.ifPresent(address -> then.run());
    }

    // really keep everything to yourself, allowing no outside interference
    void ifAddressPresentDoSomeSpecificAction() {
        address.ifPresent(address -> {
            // do this
            // do that
        });
    }
}