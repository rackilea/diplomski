public class SortExample {
    public static void main(String[] args) {
        Map<String, Integer> tally = new HashMap<String, Integer>();
        tally.put("foo", 42);
        tally.put("bar", 13);
        tally.put("Fizz", 3);
        tally.put("Buzz", 5);
        tally.put("FizzBuzz", 15);

        Comparator<String> voteComparator = new VoteComparator(tally);
        SortedSet<String> sortedByVote = new TreeSet<String>(voteComparator);
        sortedByVote.addAll(tally.keySet());
        for (String pub: sortedByVote) {
            System.out.println(pub + " (" + tally.get(pub) + " votes)");
        }
    }
}