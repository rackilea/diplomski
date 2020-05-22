List<UploadUser> uploadUsers = savedUserEntities.stream()
    .filter(t -> uploadUserMap.containsKey(t.getUserName().toLowerCase()))
    .map(t -> {
        UploadUser uploadUser = uploadUserMap.get(t.getUserName().toLowerCase());
        uploadUser.setId(t.getId());
        return uploadUser;
    })
    .collect(Collectors.toList());