public Mono<String> saveAbc(Abc toBeSaved) {
    return abcRepository.findById(toBeSaved.getId()) // (1)
            .map(abc -> transform(toBeSaved, abc))   // (2)
            .defaultIfEmpty(toBeSaved)               // (3)
            .flatMap(abcRepository::save)            // (4)
            .map(Abc::getId);                        // (5)
}

private Abc transform(Abc toBeSaved, Abc current) {
        current.setStatus(toBeSaved.getStatus());
        return current;
}