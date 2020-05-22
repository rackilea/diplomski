class UserSystemRight {
   User user
   SystemRight systemRight

   boolean equals(other) {
      if (!(other instanceof UserSystemRight)) {
          return false
      }
      other.user?.id == user?.id && other.systemRight?.id == systemRight?.id
   }

   int hashCode() {
      def builder = new HashCodeBuilder()
      if (user) builder.append(user.id)
      if (systemRight) builder.append(systemRight.id)
      builder.toHashCode()
   }


   // add some more convenience methods here if you want like...
   static UserSystemRight get(long userId, long systemRightId, String systemRightName) {
       find 'from UserSystemRight where user.id=:userId and systemRight.id=:systemRightId and systemRight.name=:systemRightName',
            [userId: userId, systemRightId: systemRightId, systemRightName: systemRightName]
   }
}