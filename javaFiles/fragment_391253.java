return infoService.findByName("info1")
    .map(info ->
        profileService.findById(info.profileId)
            .map(profile -> contentService.createContent(info, profile))
            .orElseGet(() -> contentService.createContent(info))
    );