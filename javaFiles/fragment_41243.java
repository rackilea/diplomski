@NodeEntity
class Group {

   @GraphId Long id;
   @Indexed int groupId;

   @RelatedTo(type="user_belongs_to",direction=INCOMING)
   Set<User> users;

}

interface GroupRepository extends GraphRepository<Group> {
   @Query("match (a:User)-[:user_belongs_to]-(b:Group) where a.userId = {userId} and b.groupId={groupId} return b")
   GroupEntity getGroup(@Param("userId") Long userId, @Param("groupId") Long groupId);

   // generated finder method
   GroupEntity findByGroupIdAndUsersUserId(@Param("groupId") Long groupId, @Param("userId") Long userId);
}