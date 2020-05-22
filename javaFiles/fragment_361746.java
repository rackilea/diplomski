public interface ForumFactory {
    public Forum createForum(String arg);
}

public class FooForumFactory implements ForumFactory {
    public Forum createForum(String arg) { return new FooForum(arg); }
}

Map<String, ForumFactory> factories = new HashMap<String, ForumFactory>();
factories.put("foo", new FooForumFactory());
factories.put("bar", new BarForumFactory());

...

// Create an instance ...
Forum forum = factories.get(forumType).createForum(forumName);