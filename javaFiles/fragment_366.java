@Transient
public String getDisplayName() {
    if (membership == null) {
        return null;
    }
    UserProfile userProfile = membership.getUserProfile();
    return userProfile == null ? null : userProfile.getDisplayName();
}