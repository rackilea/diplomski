public static interface Codeable {
    public int getCode();
}
public static enum TransactionType implements Codeable {
    cashback(0),deposit(1),withdraw(2),invitation(3);

    public int code; 
    TransactionType(int code) { 
        this.code = code; 
    }

    @Override
    public int getCode() {
        return code;
    }
}
public static <T extends Codeable> T fromCodeToEnum(int code, Class<T> clazz) {
    for(T t : clazz.getEnumConstants()) {
        if(t.getCode() == code) {
            return t;
        }
    }
    return null;
}
public static void main(String [] args) {
    TransactionType type = fromCodeToEnum(1, TransactionType.class);
    System.out.println(type); // deposit
}