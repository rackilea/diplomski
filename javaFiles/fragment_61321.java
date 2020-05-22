IntSupplier supplier = () -> {
    int val = ...;
    //some code
    return val;
};

int num = supplier.getAsInt();