Predicate<Attachment> isXorY = attachment -> AttachmentType.X_TYPE.equals(attachment.getAttachmentType()) || AttachmentType.Y_TYPE.equals(attachment.getAttachmentType());

releases.forEach(release -> {
        List<Attachment> filteredAttachments = release.getAttachments()
                .stream()
                .filter(isXorY)
                .collect(Collectors.toList());
        release.setAttachments(filteredAttachments);
});