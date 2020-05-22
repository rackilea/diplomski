fun getMessages(name: String, pageable: Pageable, locale: String?, subject: String?,
                          recipient: String?): Page<MessageDTO>? {
    val request = where(hasMessageName(name))
    locale?.let{ request.and(hasLocale(it)) }
    subject?.let{ request.and(hasSubject(it)) }
    recipient?.let{ request.and(hasRecipient(it))}

    return messageRepository.findAll(request, pageable)
                            .map { messageMapper.toMessageDTO(it) }
                            .takeIf { it.content.isNotEmpty() }
}