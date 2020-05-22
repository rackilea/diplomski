import java.util.*;
import java.io.*;

public class TestExecutor {
    public static void main(String[] args) throws IOException {
        Map<String, User> users = new LinkedHashMap<String, User>();
        generateUsers(users, 1000, 0.1);

        // warmup.
        int count = 10000;
        for(int i=0;i< count;i++)
            getAllUsersWithInterest(users, Interest.Golf);

        long start = System.nanoTime();
        for(int i=0;i< count;i++)
            getAllUsersWithInterest(users, Interest.Golf);
        long time = System.nanoTime() - start;
        System.out.printf("Average search time %,d micro-seconds%n", time/ count/1000);
    }

    private static Set<User> getAllUsersWithInterest(Map<String, User> users, Interest golf) {
        Set<User> ret = new LinkedHashSet<User>();
        for (User user : users.values()) {
            if (user.interests.contains(golf))
                ret.add(user);
        }
        return ret;
    }

    private static void generateUsers(Map<String, User> users, int count, double interestedInGolf) {
        Random rand = new Random();
        while(users.size() < count) {
            String name = Long.toString(rand.nextLong(), 36);
            EnumSet<Interest> interests = rand.nextFloat() < interestedInGolf
                    ? EnumSet.of(Interest.Golf) : EnumSet.noneOf(Interest.class);
            users.put(name, new User(name, interests));
        }
    }

    static class User {
        private final String name;
        private final Set<Interest> interests;

        User(String name, Set<Interest> interests) {
            this.name = name;
            this.interests = interests;
        }
    }

    enum Interest {
        Golf
    }
}