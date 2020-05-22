import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Wave {

    static class Waves {

        final Map<Friend, Integer> send = new HashMap<>();
        final Map<Friend, Integer> received = new HashMap<>();

        void addSend(Friend f) {
            add(f, send);
        }
        void addReceived(Friend f) {
            add(f, received);
        }
        void add(Friend f, Map<Friend, Integer> m) {
            m.merge(f, 1, (i, j) -> i + j);
        }
    }

    static class Friend {

        final String name;

        public Friend(String name) {
            this.name = name;
        }

        final Waves waves = new Waves();

        void wave(Friend friend) {

            if (friend == this) {
                return; // can't wave to self.
            }
            synchronized(waves) {
                waves.addSend(friend);
            }
            friend.waveBack(this); // outside of synchronized block to prevent deadlock
        }

        void waveBack(Friend friend) {

            synchronized(waves) {
                waves.addReceived(friend);
            }
        }

        String waves(boolean send) {

            synchronized(waves) {
                Map<Friend, Integer> m = (send ? waves.send : waves.received);
                return m.keySet().stream().map(f -> f.name + " : " + m.get(f))
                        .sorted().collect(Collectors.toList()).toString();
            }
        }

        @Override
        public String toString() {
            return name + ": " + waves(true) + " / " + waves(false);
        }
    }

    final static int maxThreads = 4;
    final static int maxFriends = 4;
    final static int maxWaves = 50_000;

    public static void main(String[] args) {

        try {
            List<Friend> friends = IntStream.range(0, maxFriends)
                    .mapToObj(i -> new Friend("F_" + i)).collect(Collectors.toList());
            ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
            Random random = new Random();
            List<Future<?>> requests = IntStream.range(0, maxWaves)
                    .mapToObj(i -> executor.submit(() -> 
                        friends.get(random.nextInt(maxFriends))
                            .wave(friends.get(random.nextInt(maxFriends)))
                        )
                    ).collect(Collectors.toList());
            requests.stream().forEach(f -> 
                { try { f.get(); } catch (Exception e) { e.printStackTrace(); } }
            );
            executor.shutdownNow();
            System.out.println("Friend: waves send / waves received");
            friends.stream().forEachOrdered(p -> System.out.println(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}