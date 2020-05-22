if (customers.getCUSTOMER().stream()
        .map(Customer::getINCOME)
        .anyMatch(x -> x.getGROSSMONTH1().toBigInteger().compareTo(
                x.getNETTSALMONTH1().toBigInteger()) < 0) {
    log.error("")
    throw new RuntimeException();
}