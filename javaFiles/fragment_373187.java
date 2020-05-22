private List<String> getTranslationFilesNames() {
    return SUPPORTED_LANGUAGES.stream()
            .flatMap(lang -> Stream.of(PATH_TO_FILES_WITH_TRANSLATIONS_1 + lang + FILE_EXTENSION,
                                       PATH_TO_FILES_WITH_TRANSLATIONS_2 + lang + FILE_EXTENSION)),
            .collect(Collectors.toList());
}