Group group = groupRepository.findById(userResource.getGroupId());
if (group != null) {
   User user = new User(userResource);
   user.setGroup(group);
   userRepository.save();
}