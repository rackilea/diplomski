public WorkDetail createWorker(PatchWorkerRequest request) {
    User user = buildUser(request); // builds a new User-instance from the request
    String generatedPassword = userService.generatePassword(8);
    user.setPassword(passwordEncoder.encode(generatedPassword));

    WorkDetail workDetail = buildWorkDetail(request, user); // builds a new WorkDetail-instance from the request
    workDetail.setUser(user);
    workDetailRepository.save(workDetail);
    user.setWorkDetail(workDetail);

    emailService.sendMail("SYDA", new String[]{request.getEmail()},
                "...",
                "...);
    return workDetail;
}