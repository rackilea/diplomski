@Transactional
public void addAvatar(final Long userId, final String fileName, final MultipartFile avatar) throws IOException {
    byte[] bytes = IOUtils.toByteArray(avatar.getInputStream());
    long size = avatar.getSize();
    File file = new File(bytes, size, avatar.getContentType(), fileName);

    final User user = userRepository.findOne(agencyId);
    user.setAvatar(file);
    userRepository.save(user);
}