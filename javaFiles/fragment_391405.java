return webClient.getUser(username)
        .flatMapMany(
                user -> webClient.getGroups(label)
                        .flatMap(group -> webClient.addUserToGroup(user.getId(), group.getId()).thenReturn(group))
        )
        .collectList();