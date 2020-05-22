public static TransactionType findTransactionTypeByCode(int code) {

    for(TransactionType t : TransactionType.values()) {
        if(t.getCode() == code) {
            return t;
        }
    }
    return null;
}