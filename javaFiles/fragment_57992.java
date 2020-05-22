public interface FacebookService extends RemoteService {

    List<String> getFacebookGroupIds(String suggestion);

    Icon getIconForGroup(String groupId);
}