Mono<String> generateCode() {
return Mono.fromCallable(() -> generateCodeValue())
        .flatMap(code -> emailConfirmationRepository
                .findByCode(code)
                .flatMap(codeOpt -> codeOpt
                        .map(c -> Mono.<String>error(new CodeAlreadyExistsException()))
                        .orElseGet(() -> Mono.just(code))))
        .retry(CodeAlreadyExistsException.class::isInstance)
}

class CodeAlreadyExistsException extends RuntimeException {}