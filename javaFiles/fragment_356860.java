private Long verifyRecipient(Long recipientId) throws NotFoundException {
    return recipientRepository.findById(recipientId)
        .map(Recipient::getId)
        .orElseThrow(() ->
            new NotFoundException("Recipient with ID " + recipientId + " was not found"));
}