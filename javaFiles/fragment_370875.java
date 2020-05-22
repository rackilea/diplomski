return publications.stream()
    .collect(Collectors.toMap(
        Publication::getIdPaper,
        publication -> publication.getPublicationKeyword()
            .stream()
            .collect(Collectors.toMap(
                PublicationKeyword::getKeyword,
                PublicationKeyword::getConceptFrequency))));