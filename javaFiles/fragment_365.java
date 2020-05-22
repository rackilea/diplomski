@Formula(
    "(SELECT up.displayName"
        + " FROM ModuleMembership mm"
        + " JOIN UserProfile up"
        + " ON (mm.userProfileId = up.userProfileId)"
        + " WHERE mm.moduleMembershipId = membershipId)")
String displayName;