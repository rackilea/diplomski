public Mono<VerifyPhoneToken> verifyPhoneNumber(String id, String verificationCode) {
    return verifyPhoneTokensRepository.findByUserId(id)
            .flatMap(vpt -> {
                if (verificationCode.equals(vpt.getToken())) {
                    return updateUser(id)
                            .then(verifyPhoneTokensRepository.save(vpt));
                }
                return Mono.empty();
            });
}

private Mono<User> updateUser(String id) {
    return usersRepository.findById(id)
            .flatMap(user -> {
                user.getPhones().get(0).setVerified(true);
                return usersRepository.save(user);
            });
}