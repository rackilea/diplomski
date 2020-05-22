customers.getCUSTOMER().stream()
        .filter(x -> x.getINCOME().getGROSSMONTH1().toBigInteger().compareTo(
                x.getINCOME().getNETTSALMONTH1().toBigInteger()) < 0)
        .findFirst()
        .ifPresent(x -> {
            log.error(x.getName() + " invalid: net salary is larger than gross")
            throw new RuntimeException();
        });