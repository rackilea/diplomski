class TranslateInteractor(val repository: Respository) {
    fun requestNetworkTranslated(message: String): Completable {
        return repository.fetchTranslation(message)
                .doOnSuccess { handleTranslationResponse(it) }.toCompletable()
    }

    private fun handleTranslationResponse(translation: Translation) {
        saveTranslation(
            translation.originalMessage,
            translation.translatedMessage.content,
            translation.translatedMessage.translationEngine)
    }

    private fun saveTranslation(message: String, content: String, engine: String) {
        // do whatever you want!
    }
}