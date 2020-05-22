@Transactional
public ProfileEntity updateProfile(Long userId, AddressEntity address) {
    ProfileEntity profileEntity = profileEntityRepository.findByUserId(userId);

    profileEntity.setOfficeAddress(address);
    address.setUserProfile(profileEntity);

    return profileEntityRepository.save(profileEntity);
}