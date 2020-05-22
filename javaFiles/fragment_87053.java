public class ArrayListSortExample{
    public static void main(String ... args){
        List<Player> players = new ArrayList<>();

        // Lets create 50 players with random score.
        Random random = new Random();
        for(int i = 0; i < 50; i++){
            Player player = new Player();
            player.setScore(random.nextInt(100));
            players.add(player);
        }

        // Lets sort players by score
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getScore() - o2.getScore();
            }
        });

        // Print 3 top players
        for(int i = 0; i < 3; i++){
            System.out.println((i+1) + "º place: " + players.get(i).getScore() + " score");
        }
    }

    public static class Player{
        private int score;

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}